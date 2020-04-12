package com.demo.sunbelt.module

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import com.demo.sunbelt.data.interceptor.AuthInterceptor
import com.demo.sunbelt.util.AppPreferences
import com.demo.sunbelt.data.interceptor.RefreshAuthTokenInterceptor
import com.demo.sunbelt.data.remote.net.ListRemoteApi
import com.demo.sunbelt.data.remote.source.ListDataSource
import com.demo.sunbelt.data.repository.ListRepository
import com.demo.sunbelt.domain.usecase.ListUseCase
import com.demo.sunbelt.presentation.viewmodel.ListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val appModule = module {

    /* Android Services */
    single {
        androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }
    single<SharedPreferences> {
        androidContext().getSharedPreferences(
            AppPreferences.SHARED_PREFERENCES_NAME,
            Context.MODE_PRIVATE
        )
    }


    val loggin = HttpLoggingInterceptor()
    loggin.level = HttpLoggingInterceptor.Level.BODY

    /* Retrofit */
    single {
        OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(1, TimeUnit.MINUTES)
            .writeTimeout(1, TimeUnit.MINUTES)
            .addInterceptor(AuthInterceptor(AppPreferences))
            .addInterceptor(RefreshAuthTokenInterceptor(AppPreferences))
            .addInterceptor(loggin)
            .build()
    }
    single {
        Retrofit.Builder()
            .baseUrl(URL_BASE_EXPERIENCE_API)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    /* Remote API */
    single { get<Retrofit>().create(ListRemoteApi::class.java) as ListRemoteApi }

    /* DataSource */
    factory { ListDataSource(get()) }

    /* Repositories */
    factory { ListRepository(get()) }

    /* View models */
    viewModel { ListViewModel(get()) }

    /* UseCases */
    factory { ListUseCase(get()) }

}

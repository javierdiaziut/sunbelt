package com.demo.sunbelt.module

import android.app.Application
import com.jakewharton.threetenabp.AndroidThreeTen
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

const val URL_BASE_EXPERIENCE_API = "https://newsapi.org/v2/"

open class SunbeltApp : Application(){

    override fun onCreate() {
        super.onCreate()
        initKoin()
        AndroidThreeTen.init(this)
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@SunbeltApp)
            modules(listOf(appModule))
        }
    }

}
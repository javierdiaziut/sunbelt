package com.demo.sunbelt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.demo.sunbelt.data.remote.model.ListResponseEntry
import com.demo.sunbelt.databinding.ActivityMainBinding
import com.demo.sunbelt.presentation.viewmodel.ListViewModel
import com.up.core.coroutines.Result
import com.up.core.extension.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val listViewModel: ListViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(listViewModel) {
            observe(listLiveData, ::newsListObserver)
        }

        listViewModel.getNewsListDomain("ve")

    }

    private fun newsListObserver(result: Result<ListResponseEntry>?) {
        when (result) {
            is Result.OnSuccess -> {
                hideLoading()
            }
            is Result.OnLoading -> {
                showLoading()
            }
            is Result.OnError -> {
            }
            else -> {
            }
        }
    }

    private fun hideLoading() {
        binding.progressBar.visibility = View.GONE
    }

    private fun showLoading() {
        binding.progressBar.visibility = View.VISIBLE
    }
}

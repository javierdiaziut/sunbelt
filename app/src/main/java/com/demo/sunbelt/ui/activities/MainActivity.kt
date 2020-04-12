package com.demo.sunbelt.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.sunbelt.data.remote.model.ListResponseEntry
import com.demo.sunbelt.data.remote.model.toArticle
import com.demo.sunbelt.databinding.ActivityMainBinding
import com.demo.sunbelt.domain.model.Article
import com.demo.sunbelt.presentation.viewmodel.ListViewModel
import com.demo.sunbelt.ui.adapters.NewsAdapter
import com.rankmi.app.data.DataConstants.EXTRA_DETAIL
import com.up.core.coroutines.Result
import com.up.core.extension.observe
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(), NewsAdapter.ItemListener {

    private lateinit var binding: ActivityMainBinding
    private val listViewModel: ListViewModel by viewModel()
    lateinit var newsListAdapter: NewsAdapter
    private var arrayNews: ArrayList<Article> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(listViewModel) {
            observe(listLiveData, ::newsListObserver)
        }

        listViewModel.getNewsListDomain("co")

    }

    private fun newsListObserver(result: Result<ListResponseEntry>?) {
        when (result) {
            is Result.OnSuccess -> {
                hideLoading()
                arrayNews = result.value.articles
                initNewsAdapter()
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

    private fun initNewsAdapter() {
        newsListAdapter = NewsAdapter(this, arrayNews)
        newsListAdapter.setClickListener(this)
        binding.recyclerNews.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        binding.recyclerNews.adapter = newsListAdapter
    }

    override fun onClickItem(position: Int) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_DETAIL, arrayNews[position])
        startActivity(intent)
    }
}

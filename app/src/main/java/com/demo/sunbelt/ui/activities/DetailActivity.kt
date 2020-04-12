package com.demo.sunbelt.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.demo.sunbelt.R
import com.demo.sunbelt.databinding.ActivityDetailBinding
import com.demo.sunbelt.domain.model.Article
import com.rankmi.app.data.DataConstants
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val article = intent.getParcelableExtra<Article>(DataConstants.EXTRA_DETAIL)
        article?.let {
            it.urlToImage.let {image ->
                Picasso.get().load(image)
                    .error(R.drawable.dummy_img)
                    .into(binding.imgNews)
            }

            binding.textTitle.text = it.title
            binding.textContent.text = it.content
        }

    }
}

package com.demo.sunbelt.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo.sunbelt.R
import com.demo.sunbelt.domain.model.Article
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_list.view.*

class NewsAdapter(
    private val context: Context,
    private val data: ArrayList<Article>
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var itemListener: ItemListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        holder.itemView.titleArticle.text = data[position].title
        holder.itemView.textSourceAuthor.text = String.format(
            context.resources.getString(R.string.source_author),
            data[position].source.name, data[position].author
        )

        Picasso.get().load(data[position].urlToImage)
            .error(R.drawable.dummy_img)
            .into(holder.itemView.imgNews)

        holder.itemView.setOnClickListener {
            itemListener?.let {
                it.onClickItem(position)
            }
        }
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface ItemListener {
        fun onClickItem(position: Int)
    }


    // allows clicks events to be caught
    internal fun setClickListener(itemListener: ItemListener) {
        this.itemListener = itemListener
    }
}
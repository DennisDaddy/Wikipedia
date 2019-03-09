package org.dennis.wikipedia.activities.holders

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_card_item.view.*
import org.dennis.wikipedia.R
import org.dennis.wikipedia.activities.ArticleDetailActivity
import org.dennis.wikipedia.activities.models.WikiPage

class ListItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.result_icon)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.result_title)
    private var currentPage: WikiPage? = null

    init {
        itemView.setOnClickListener { view: View? ->
            var detailPageIntent = Intent(itemView.context, ArticleDetailActivity::class.java)
            var pageJson = Gson().toJson(currentPage)
            detailPageIntent.putExtra("page", pageJson)
            itemView.context.startActivity(detailPageIntent)
        }
    }


    fun updateWithPage(page: WikiPage){

        // load image lazily with picaso
        if(page.thumbnail != null)
            Picasso.get().load(page.thumbnail!!.source).into(articleImageView)
        titleTextView.text = page.title
        currentPage = page
    }

    }
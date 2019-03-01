package org.dennis.wikipedia.activities.holders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.article_card_item.view.*
import org.dennis.wikipedia.R
import org.dennis.wikipedia.activities.models.WikiPage

class CardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val articleImageView: ImageView = itemView.findViewById<ImageView>(R.id.article_image)
    private val titleTextView: TextView = itemView.findViewById<TextView>(R.id.article_title)

    private var currentPage: WikiPage? = null

    fun updateWithPage(page: WikiPage){
        currentPage = page

        titleTextView.text = page.title

        // load image lazily with picasso
        if(page.thumbnail != null)
            Picasso.with(itemView.context).load(page.thumbnail!!.source).into(articleImageView)
    }
}
package org.dennis.wikipedia.activities.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import org.dennis.wikipedia.R
import org.dennis.wikipedia.activities.holders.CardHolder
import org.dennis.wikipedia.activities.holders.LisItemHolder
import org.dennis.wikipedia.activities.models.WikiPage

class ArticleListItemRecyclerAdapter : RecyclerView.Adapter<LisItemHolder>() {
    val currentResults : ArrayList<WikiPage> = ArrayList<WikiPage>()

    override fun getItemCount(): Int {
        return currentResults.size //temporary
    }

    override fun onBindViewHolder(holder: LisItemHolder, position: Int) {
        // this is where will update your view
        var page = currentResults[position]
        holder.updateWithPage(page)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LisItemHolder {
        var cardItem = LayoutInflater.from(parent?.context).inflate(R.layout.article_list_item, parent, false)
        return LisItemHolder(cardItem)
    }
}
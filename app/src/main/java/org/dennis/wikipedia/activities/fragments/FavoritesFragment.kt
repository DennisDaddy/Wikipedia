package org.dennis.wikipedia.activities.fragments


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_favorites.*

import org.dennis.wikipedia.R
import org.dennis.wikipedia.activities.WikiApplication
import org.dennis.wikipedia.activities.adapters.ArticleCardRecyclerAdapter
import org.dennis.wikipedia.activities.adapters.ArticleListItemRecyclerAdapter
import org.dennis.wikipedia.activities.managers.WikiManager
import org.dennis.wikipedia.activities.models.WikiPage
import org.jetbrains.anko.doAsync


/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment() {

    private var wikiManager: WikiManager? = null
    var favoritesRecyler: RecyclerView? = null
    private val adapter: ArticleCardRecyclerAdapter = ArticleCardRecyclerAdapter()

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        wikiManager = (activity!!.applicationContext as WikiApplication).wikiManager
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_favorites, container, false)

        favoritesRecyler = view.findViewById<RecyclerView>(R.id.favorites_article_recycler);
        favoritesRecyler!!.layoutManager = LinearLayoutManager(context)
        favoritesRecyler!!.adapter == adapter

        return view
    }

    override fun onResume() {
        super.onResume()

        doAsync {
            val favoriteArticles = wikiManager!!.getFavorites()
            adapter.currentResults.clear()
            adapter.currentResults.addAll(favoriteArticles as ArrayList<WikiPage>)
            activity!!.runOnUiThread { adapter.notifyDataSetChanged() }
        }
    }

}// Required empty public constructor
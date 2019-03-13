package org.dennis.wikipedia.activities.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_favorites.*

import org.dennis.wikipedia.R
import org.dennis.wikipedia.activities.adapters.ArticleCardRecyclerAdapter
import org.dennis.wikipedia.activities.adapters.ArticleListItemRecyclerAdapter


/**
 * A simple [Fragment] subclass.
 */
class FavoritesFragment : Fragment() {

    var favoritesRecyler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.fragment_favorites, container, false)

        favoritesRecyler = view.findViewById<RecyclerView>(R.id.favorites_article_recycler);
        favoritesRecyler!!.layoutManager = LinearLayoutManager(context)
        favoritesRecyler!!.adapter = ArticleCardRecyclerAdapter()

        return view
    }

}// Required empty public constructor
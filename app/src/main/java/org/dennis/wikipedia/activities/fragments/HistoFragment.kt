package org.dennis.wikipedia.activities.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_histo.*

import org.dennis.wikipedia.R
import org.dennis.wikipedia.activities.adapters.ArticleCardRecyclerAdapter
import org.dennis.wikipedia.activities.adapters.ArticleListItemRecyclerAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HistoFragment : Fragment() {

    var historyRecycler: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_histo, container, false)

        historyRecycler = view.findViewById<RecyclerView>(R.id.history_article_recycler)
        historyRecycler!!.layoutManager = LinearLayoutManager(context)
        historyRecycler!!.adapter = ArticleListItemRecyclerAdapter()

        return view
    }


}

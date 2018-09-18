package com.example.andhika.pbp_android.section.Main.fragment

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.common.GeneralRecyclerViewAdapter
import com.example.andhika.pbp_android.model.Makul
import com.example.andhika.pbp_android.showShortToast
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.android.synthetic.main.viewholder_makul.view.*

class MainFragment : DaggerFragment(), MainView {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private lateinit var presenter: MainFragmentPresenter
    private val listMakulResponse = mutableListOf<Makul>()
    private val listAdapter = GeneralRecyclerViewAdapter(R.layout.viewholder_makul, listMakulResponse, { list, _, _ ->
    }, { list, view: View ->
        view.tv_makul.text = list.namaMakul
    })

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.main_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(rv_list) {
            adapter = listAdapter
            layoutManager = GridLayoutManager(activity, 2)
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun goToMain(response: List<Makul>) {
        listMakulResponse.clear()
        listMakulResponse.addAll(response)
        listAdapter.notifyDataSetChanged()
    }

    override fun showError(any: Any) {
        activity?.showShortToast(any.toString())
    }

    override fun setPresenter(presenter: MainFragmentPresenter) {
        this.presenter = presenter
        lifecycle.addObserver(this.presenter)
    }
}
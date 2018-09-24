package com.example.andhika.pbp_android.section.Main.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.common.GeneralRecyclerViewAdapter
import com.example.andhika.pbp_android.model.Dosen
import com.example.andhika.pbp_android.model.DosenResponse
import kotlinx.android.synthetic.main.fragment_dosen.*
import kotlinx.android.synthetic.main.viewholder_dosen.view.*

@SuppressLint("SetTextI18n")
class DosenFragment : Fragment(), DosenView {

    companion object {
        fun newInstance() : DosenFragment{
            return DosenFragment()
        }
    }
    private lateinit var presenter: DosenPresenter
    private val listDosen = mutableListOf<Dosen>()
    private val dosenAdapter by lazy {
        GeneralRecyclerViewAdapter(R.layout.viewholder_dosen, listDosen, { _, _, _ ->
        }, { list, view ->
            view.tv_number.text = "${list.idDosen}."
            view.tv_nama_dosen.text = list.namaDosen
        })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_dosen, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(rv_list_dosen){
            adapter = dosenAdapter
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun showError(any: Any) {
    }

    override fun setPresenter(presenter: DosenPresenter) {
        this.presenter = presenter
        lifecycle.addObserver(this.presenter)
    }

    override fun loadMainFragment() {
        presenter.getListDosen()
    }

    override fun goToMain(response: DosenResponse) {
        listDosen.clear()
        listDosen.addAll(response.listDosen)
        dosenAdapter.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        presenter.getListDosen()
    }
}
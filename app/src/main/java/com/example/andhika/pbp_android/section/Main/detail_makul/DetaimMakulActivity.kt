package com.example.andhika.pbp_android.section.Main.detail_makul

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.common.GeneralRecyclerViewAdapter
import com.example.andhika.pbp_android.model.Event
import com.example.andhika.pbp_android.model.GetEventRequest
import com.example.andhika.pbp_android.model.GetEventResponse
import com.example.andhika.pbp_android.model.GetListRequest
import com.example.andhika.pbp_android.model.ListIdMakul
import com.example.andhika.pbp_android.model.Makul
import com.example.andhika.pbp_android.section.Main.add_res.AddEventActivity
import kotlinx.android.synthetic.main.detail_makul_activity.*
import kotlinx.android.synthetic.main.viewholder_event.view.*
import javax.inject.Inject

class DetaimMakulActivity : BaseActivity(), DetailMakulContract.View {


    @Inject
    lateinit var presenter: DetailMakulPresenter
    private val listMakul = mutableListOf<Event>()

    private val listAdapter by lazy {
        GeneralRecyclerViewAdapter(R.layout.viewholder_event, listMakul, { _, _, _ ->
        }, { list, view ->
            view.tv_number.text = list.idEvent
            view.tv_event.text = list.namaEvent
            view.tv_detil_event.text = list.detil_nama
        })
    }

    override fun onSetupLayout() {
        setContentView(R.layout.detail_makul_activity)
        setupToolbarTitle(toolbar_layout as Toolbar, title = R.string.detailMakul, drawable = R.drawable.ic_back_black_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        with(rv_list){
            adapter = listAdapter
            layoutManager = LinearLayoutManager(this@DetaimMakulActivity,LinearLayoutManager.VERTICAL,false)
        }
        val bundle = intent.extras
        presenter.getListMakul(GetListRequest(bundle.getInt("id")))
        presenter.getEvent(GetEventRequest(bundle.getInt("id")))

    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun goToMain(response: ListIdMakul) {
        tv_dosen.text = response.message?.get(0)?.namaDosen
        tv_location_makul.text = response.message?.get(0)?.lokasiMakul
        val bundle = Bundle().apply {
            response.message?.get(0)?.idMakul?.let { putInt("id", it) }
        }
        cl_edit.setOnClickListener {
            startActivity(Intent(this@DetaimMakulActivity, EditDosenActivity::class.java)
                    .apply {
                        putExtras(bundle)
                    })
        }

        fab_add.setOnClickListener {
            startActivity(Intent(this@DetaimMakulActivity,AddEventActivity::class.java).apply {
                putExtras(bundle)
            })
        }
    }

    override fun showError(any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getEvent(response: GetEventResponse) {
        listMakul.clear()
        listMakul.addAll(response.message)
        Log.d("DHIKA", "res: ${listMakul.size}");
        listAdapter.notifyDataSetChanged()
    }

}
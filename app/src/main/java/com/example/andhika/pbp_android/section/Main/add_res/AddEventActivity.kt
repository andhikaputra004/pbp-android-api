package com.example.andhika.pbp_android.section.Main.add_res

import android.support.v7.widget.Toolbar
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.AddEventRequest
import com.example.andhika.pbp_android.model.AddResponse
import com.example.andhika.pbp_android.showShortToast
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.add_event_activity.*
import javax.inject.Inject

class AddEventActivity : BaseActivity(), AddEventContract.View {

    @Inject
    lateinit var presenter: AddEventPresenter

    override fun onSetupLayout() {
        setContentView(R.layout.add_event_activity)
        setupToolbarTitle(toolbar_layout as Toolbar, title = R.string.txt_add_event, drawable = R.drawable.ic_back_black_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        presenter.setAddValidation(Observable.combineLatest(
                RxTextView.textChanges(et_detail_event)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_tgl)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_name)
                        .map { it.isNotEmpty() },
                Function3 { makul: Boolean, dosen: Boolean, lokasi: Boolean ->
                    makul && dosen && lokasi
                })
                .observeOn(AndroidSchedulers.mainThread())) {
            btn_add.isEnabled = it
        }
        val bundle = intent.extras
        btn_add.setOnClickListener {
            presenter.insertEvent(AddEventRequest(et_name.text.toString(), bundle.getInt("id"), et_tgl.text.toString(), et_detail_event.text.toString()))
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun goToMain(response: AddResponse) {
        showShortToast("Sukses Add")
    }

    override fun showError(any: Any) {
        showShortToast("Something went Wrong")
    }
}
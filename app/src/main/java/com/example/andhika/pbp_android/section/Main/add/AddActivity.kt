package com.example.andhika.pbp_android.section.Main.add

import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.AddRequest
import com.example.andhika.pbp_android.model.AddResponse
import com.example.andhika.pbp_android.showShortToast
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function3
import kotlinx.android.synthetic.main.activity_add.*
import javax.inject.Inject

class AddActivity : BaseActivity(), AddContract.View {

    @Inject
    lateinit var presenter: AddPresenter

    override fun onSetupLayout() {
        setContentView(R.layout.activity_add)
        setupToolbarTitle(toolbar_layout_add as Toolbar, title = R.string.txt_add, drawable = R.drawable.ic_back_black_24dp)

    }

    override fun onViewReady() {
        presenter.setAddValidation(Observable.combineLatest(
                RxTextView.textChanges(et_nama_makul)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_lokasi_makul)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_nama_dosen)
                        .map { it.isNotEmpty() },
                Function3{ makul: Boolean, dosen: Boolean , lokasi : Boolean->
                    makul && dosen && lokasi
                })
                .observeOn(AndroidSchedulers.mainThread())) {
            btn_add.isEnabled = it
        }

        btn_add.setOnClickListener {
            presenter.insertMakul(AddRequest(et_nama_makul.text.toString(),et_nama_dosen.text.toString(),et_lokasi_makul.text.toString()))
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun goToMain(response: AddResponse) {
        Log.d("DHIKA", "res: ${response.message}");
        response.message?.let { showShortToast(it) }
    }

    override fun showError(any: Any) {
        showShortToast("Something went wrong")
    }

}
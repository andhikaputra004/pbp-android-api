package com.example.andhika.pbp_android.section.Main.detail_makul

import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.EditDosenRequest
import com.example.andhika.pbp_android.model.EditDosenResponse
import com.example.andhika.pbp_android.showShortToast
import kotlinx.android.synthetic.main.edit_dosen_activity.*
import javax.inject.Inject

class EditDosenActivity : BaseActivity() ,EditDosenContract.View{

    @Inject
    lateinit var presenter: EditDosenPresenter
    override fun onSetupLayout() {
        setContentView(R.layout.edit_dosen_activity)
        setupToolbarTitle(toolbar_layout_edit_dosen as Toolbar,title = R.string.txt_subject,drawable = R.drawable.ic_back_black_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        val bundle = intent.extras
        btn_edit.setOnClickListener {
            presenter.getListMakul(EditDosenRequest(bundle.getInt("id"),et_dosen.text.toString(),et_lokasi_edit.text.toString()))
        }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMain(response: EditDosenResponse) {
        showShortToast("Edit sukses")
    }

    override fun showError(any: Any) {
        showShortToast("Something went wrong")
    }

}
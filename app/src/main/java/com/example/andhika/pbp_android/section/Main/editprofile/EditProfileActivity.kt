package com.example.andhika.pbp_android.section.Main.editprofile

import android.support.v7.widget.Toolbar
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.AddResponse
import com.example.andhika.pbp_android.model.EditProfileRequest
import com.example.andhika.pbp_android.showShortToast
import kotlinx.android.synthetic.main.edit_profile_activity.*
import javax.inject.Inject

class EditProfileActivity : BaseActivity(),EditProfileContract.View{

    @Inject
    lateinit var presenter: EditProfilePresenter

    override fun onSetupLayout() {
        setContentView(R.layout.edit_profile_activity)
        setupToolbarTitle(toolbar_layout as Toolbar,title = R.string.txt_edit_profile,drawable = R.drawable.ic_back_black_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        val bundle = intent.extras
        btn_edit.setOnClickListener {
            presenter.postUpdateUser(EditProfileRequest(bundle.getInt("id"),et_name.text.toString(),et_email.text.toString()))
        }

    }

    override fun showLoading() {

    }

    override fun dismissLoading() {

    }

    override fun goToMain(response: AddResponse) {
        showShortToast("Sukses Edit")
    }

    override fun showError(any: Any) {
        showShortToast("Something Went Wrong")
    }


}
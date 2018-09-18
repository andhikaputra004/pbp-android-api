package com.example.andhika.pbp_android.section.register

import android.content.Intent
import android.support.v7.widget.Toolbar
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.RegisterRequest
import com.example.andhika.pbp_android.section.login.LoginActivity
import com.example.andhika.pbp_android.showShortToast
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function4
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject

class RegisterActivity : BaseActivity(), RegisterContract.View {

    @Inject
    lateinit var presenter: RegisterPresenter

    override fun onSetupLayout() {
        setContentView(R.layout.activity_register)
        setupToolbarTitle(toolbar_layout as Toolbar,title = R.string.txt_register,drawable = R.drawable.ic_back_black_24dp)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        presenter.setRegisterValidation(Observable.combineLatest(
                RxTextView.textChanges(et_nama_user)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_username)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_password)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_email)
                        .map { it.isNotEmpty() },
                Function4 { nama: Boolean, username: Boolean, password: Boolean, email: Boolean ->
                    nama && username && password && email
                }
        ).observeOn(AndroidSchedulers.mainThread())) {
            btn_register.isEnabled = it
        }

        btn_register.setOnClickListener {
            presenter.postRegister(RegisterRequest(et_nama_user.text.toString()
                    , et_username.text.toString(), et_password.text.toString()
                    , et_email.text.toString()))
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun goToMain() {
        startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
    }

    override fun showError(any: Any) {
        showShortToast(any.toString())
    }

}
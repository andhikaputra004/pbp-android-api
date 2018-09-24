package com.example.andhika.pbp_android.section.login

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.util.Log
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.LoginRequest
import com.example.andhika.pbp_android.model.LoginResponse
import com.example.andhika.pbp_android.section.Main.MainActivity
import com.example.andhika.pbp_android.section.register.RegisterActivity
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : BaseActivity(), LoginContract.View {

    companion object {
        val ID = "id"
        val NAMA = "nama_user"
    }


    @Inject
    lateinit var presenter: LoginPresenter

    override fun onSetupLayout() {
        setContentView(R.layout.activity_login)
        setupToolbarTitleNoBack(toolbar_layout as Toolbar,title = R.string.txt_login)
    }

    override fun onViewReady() {
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        presenter.setLoginValidation(Observable.combineLatest(
                RxTextView.textChanges(et_username)
                        .map { it.isNotEmpty() },
                RxTextView.textChanges(et_password)
                        .map { it.isNotEmpty() },
                BiFunction { user: Boolean, pass: Boolean ->
                    user && pass
                })
                .observeOn(AndroidSchedulers.mainThread())) {
            btn_login.isEnabled = it
        }

        btn_login.setOnClickListener {
            presenter.postLogin(LoginRequest(et_username.text.toString(),et_password.text.toString()))
        }

        tv_sign_up.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }
    }

    override fun showLoading() {
    }

    override fun dismissLoading() {
    }

    override fun goToMain(response: LoginResponse) {
        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
    }

    override fun showError(any: Any) {
        Log.d("DHIKA", "error: $any");
    }


}

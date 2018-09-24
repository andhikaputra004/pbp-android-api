package com.example.andhika.pbp_android.section.register

import android.content.Intent
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.base.BaseActivity
import com.example.andhika.pbp_android.model.RegisterRequest
import com.example.andhika.pbp_android.section.login.LoginActivity
import com.example.andhika.pbp_android.showShortToast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.jakewharton.rxbinding2.widget.RxTextView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Function4
import kotlinx.android.synthetic.main.activity_register.*
import javax.inject.Inject


class RegisterActivity : BaseActivity(), RegisterContract.View {

    @Inject
    lateinit var presenter: RegisterPresenter

    var firebaseAuth: FirebaseAuth? = null
    override fun onSetupLayout() {
        setContentView(R.layout.activity_register)
        setupToolbarTitle(toolbar_layout as Toolbar, title = R.string.txt_register, drawable = R.drawable.ic_back_black_24dp)
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
    }

    override fun showError(any: Any) {
        redirectLoginScreen()
    }

    private fun registerNewEmail(email: String, password: String) {
        showDialog()
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
            Log.d("TAG", "onComplete: ${task.isSuccessful}")

            when (task.isSuccessful) {
                true -> {
                    Log.d("TAG", "onComplete: AuthState: ${FirebaseAuth.getInstance().currentUser?.uid} ")
                    sendVerificationEmail()
                    FirebaseAuth.getInstance().signOut()
                    redirectLoginScreen()
                }
                false -> {
                    Toast.makeText(this, "Unable to register", Toast.LENGTH_LONG)
                }
            }
            hideDialog()

        }
    }

    private fun sendVerificationEmail() {
        val user = FirebaseAuth.getInstance().currentUser

        user!!.sendEmailVerification()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        FirebaseAuth.getInstance().signOut()
                        startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                        finish()
                    } else {
                        overridePendingTransition(0, 0)
                        finish()
                        overridePendingTransition(0, 0)
                        startActivity(intent)

                    }
                }

    }

    private fun redirectLoginScreen() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    private fun showDialog() {
        mProgressBar?.visibility = View.VISIBLE
    }

    private fun hideDialog() {
        if (mProgressBar?.visibility == View.VISIBLE) {
            mProgressBar?.visibility = View.VISIBLE
        }
    }


}
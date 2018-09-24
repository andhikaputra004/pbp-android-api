package com.example.andhika.pbp_android.section.Main.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.model.ProfileRequest
import com.example.andhika.pbp_android.model.ProfileResponse
import com.example.andhika.pbp_android.section.Main.editprofile.EditProfileActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(), ProfileView {

    companion object {
        fun newInstance(): ProfileFragment {
            return ProfileFragment()
        }
    }
    private lateinit var presenter: ProfilePresenter


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) = inflater.inflate(R.layout.fragment_profile, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMain(response: ProfileResponse) {
        tv_profile.text = response.dataUser?.namaUser
        tv_email.text = response.dataUser?.email
        val bundle = Bundle().apply {
            response.dataUser?.idUser?.let { putInt("id", it) }
        }
        Log.d("DHIKA", "bundle: $bundle");
        cl_edit.setOnClickListener {
            startActivity(Intent(activity, EditProfileActivity::class.java).apply {
                putExtras(bundle)
            })
        }
    }

    override fun showError(any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResume() {
        super.onResume()
        presenter.profileRequest(ProfileRequest("test"))
    }

    override fun setPresenter(presenter: ProfilePresenter) {
        this.presenter = presenter
        lifecycle.addObserver(this.presenter)
    }

    override fun loadMainFragment() {
    }


}
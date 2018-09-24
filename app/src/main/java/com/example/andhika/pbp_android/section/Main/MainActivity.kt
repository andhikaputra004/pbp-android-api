package com.example.andhika.pbp_android.section.Main

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.model.GetListMakulResponse
import com.example.andhika.pbp_android.network.NetworkManager
import com.example.andhika.pbp_android.section.Main.add.AddActivity
import com.example.andhika.pbp_android.section.Main.fragment.DosenFragment
import com.example.andhika.pbp_android.section.Main.fragment.DosenPresenter
import com.example.andhika.pbp_android.section.Main.fragment.MainFragment
import com.example.andhika.pbp_android.section.Main.fragment.MainFragmentPresenter
import com.example.andhika.pbp_android.section.Main.fragment.ProfileFragment
import com.example.andhika.pbp_android.section.Main.fragment.ProfilePresenter
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, MainContract.View {

    @Inject
    lateinit var presenter: MainPresenter

    @Inject
    lateinit var networkManager: NetworkManager
    private val mainFragment = MainFragment.newInstance()
    private val dosenFragment = DosenFragment.newInstance()
    private lateinit var mainPresenter: MainFragmentPresenter
    private lateinit var dosenPresenter: DosenPresenter
    private lateinit var profilePresenter: ProfilePresenter
    private val profileFragment = ProfileFragment.newInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        setSupportActionBar (toolbar)
        presenter.takeView(this)
        lifecycle.addObserver(presenter)
        initpresenter()
        initFragment()
        fab.setOnClickListener { view ->
            startActivity(Intent(this@MainActivity, AddActivity::class.java))
        }
        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        clearFragmentDisposable()
        val fragment = when (item.itemId) {
            R.id.nav_camera -> {
                mainFragment
            }
            R.id.nav_gallery -> {
                dosenFragment
            }
            R.id.nav_slideshow -> {
                profileFragment
            }
            else -> {
                mainFragment
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        supportFragmentManager.beginTransaction().replace(R.id.fl_content, fragment).commit()
        return true
    }


    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun dismissLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun goToMain(response: GetListMakulResponse) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(any: Any) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun initpresenter() {
        mainPresenter = MainFragmentPresenter(networkManager, mainFragment)
        dosenPresenter = DosenPresenter(networkManager, dosenFragment)
        profilePresenter = ProfilePresenter(networkManager,profileFragment)
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction().replace(R.id.fl_content, mainFragment).commit()
    }

    private fun clearFragmentDisposable() {
        dosenPresenter.clearCompositeDisposable()
        mainPresenter.clearCompositeDisposable()
    }

}

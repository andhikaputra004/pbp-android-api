package com.example.andhika.pbp_android.base

import android.app.Activity
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import com.example.andhika.pbp_android.R
import com.example.andhika.pbp_android.getColorCompat
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.toolbar.*

abstract class BaseActivity : DaggerAppCompatActivity() {

    private val actDisposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onSetupLayout()
        onViewReady()
    }

    fun setupToolbarTitle(toolbarId: Toolbar, title: Int = R.string.empty_string, drawable: Int = R.drawable.ic_back_black_24dp) {
        setSupportActionBar(toolbarId)
        supportActionBar?.let {
            it.setDisplayShowTitleEnabled(false)
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setHomeAsUpIndicator(drawable)
        }
        toolbar_title.setText(title)
    }

    fun changeTitleToolbar(title: Int) {
        toolbar_title.setText(title)
    }

    fun changeTitleToolbar(title: String) {
        toolbar_title.text = title
    }

    fun changeTitleToolbarColor(color: Int) {
        toolbar_title.setTextColor(getColorCompat(color))
    }

    fun changeToolbarColor(color: Int) {
        supportActionBar?.setBackgroundDrawable(ColorDrawable(getColorCompat(color)))
    }

    fun changeStatusBarColor(color: Int) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor = color
        }
    }

    fun setupToolbarTitleNoBack(toolbarId: Toolbar, title: Int = R.string.empty_string) {
        setSupportActionBar(toolbarId)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        toolbar_title.setText(title)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    protected abstract fun onSetupLayout()
    protected abstract fun onViewReady()

    fun Disposable.track() {
        actDisposables.add(this)
    }

    override fun onDestroy() {
        actDisposables.clear()
        super.onDestroy()
    }
}
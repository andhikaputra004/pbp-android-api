package com.example.andhika.pbp_android.base

interface BasePresenterInterface<T> {
    fun takeView(view: T)
    fun dropView()
}
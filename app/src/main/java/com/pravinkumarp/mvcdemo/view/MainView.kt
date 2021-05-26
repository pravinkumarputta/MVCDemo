package com.pravinkumarp.mvcdemo.view

import android.view.View

interface MainView {
    fun initView()
    fun getRootView(): View
    fun bindDataToView()
}
package com.pravinkumarp.mvcdemo.view.detailactivity

import com.pravinkumarp.mvcdemo.model.bean.Fruit
import com.pravinkumarp.mvcdemo.view.MainView

interface DetailActivityView: MainView {
    fun showSelectedFruit(fruit: Fruit)
    fun updateViewOnUpdate(fruit: Fruit)
    fun updateViewOnDelete(fruit: Fruit)
    fun navigateToMainActivityOnDelete()
    fun showError(message: String)
}
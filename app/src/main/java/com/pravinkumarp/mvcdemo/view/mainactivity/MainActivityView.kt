package com.pravinkumarp.mvcdemo.view.mainactivity

import com.pravinkumarp.mvcdemo.model.bean.Fruit
import com.pravinkumarp.mvcdemo.view.MainView

interface MainActivityView : MainView {
    fun showAllFruits(fruits: ArrayList<Fruit>)
    fun updateViewOnAddFruit(fruits: ArrayList<Fruit>)
    fun showError(message: String)
    fun navigateToDetailsActivity(id: Int)
}
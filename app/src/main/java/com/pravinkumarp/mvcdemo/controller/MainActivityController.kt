package com.pravinkumarp.mvcdemo.controller

import com.pravinkumarp.mvcdemo.model.MainModelImplementor
import com.pravinkumarp.mvcdemo.model.bean.Fruit
import com.pravinkumarp.mvcdemo.view.mainactivity.MainActivityViewImplementor

class MainActivityController(
    private val mainActivityViewImplementor: MainActivityViewImplementor,
    private val mainModelImplementor: MainModelImplementor
) {
    fun onViewLoaded() {
        try {
            mainActivityViewImplementor.showAllFruits(mainModelImplementor.getAllFruits())
        } catch (ex: Exception) {
            mainActivityViewImplementor.showError(ex.message!!)
        }
    }

    fun onAddFruitButtonClicked(fruit: Fruit) {
        try {
            mainModelImplementor.addFruit(fruit)
            mainActivityViewImplementor.updateViewOnAddFruit(mainModelImplementor.getAllFruits())
        } catch (ex: Exception) {
            mainActivityViewImplementor.showError(ex.message!!)
        }
    }

    fun onFruitListItemClickListener(id: Int) {
        mainActivityViewImplementor.navigateToDetailsActivity(id)
    }
}
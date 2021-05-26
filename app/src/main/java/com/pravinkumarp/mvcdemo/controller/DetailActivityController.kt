package com.pravinkumarp.mvcdemo.controller

import com.pravinkumarp.mvcdemo.model.MainModelImplementor
import com.pravinkumarp.mvcdemo.model.bean.Fruit
import com.pravinkumarp.mvcdemo.view.detailactivity.DetailActivityViewImplementor

class DetailActivityController(private val detailActivityViewImplementor: DetailActivityViewImplementor, private val mainModelImplementor: MainModelImplementor) {

    fun onViewLoaded(id: Int) {
        detailActivityViewImplementor.showSelectedFruit(mainModelImplementor.getFruit(id))
    }

    fun onFruitUpdateButtonClicked(fruit: Fruit) {
        try {
            mainModelImplementor.updateFruit(fruit)
            detailActivityViewImplementor.updateViewOnUpdate(mainModelImplementor.getFruit(fruit.id!!));
        } catch (ex: Exception) {
            detailActivityViewImplementor.showError(ex.message!!)
        }
    }

    fun onFruitDeleteButtonClicked(fruit: Fruit) {
        try {
            mainModelImplementor.deleteFruit(fruit)
            detailActivityViewImplementor.updateViewOnDelete(fruit);
            detailActivityViewImplementor.navigateToMainActivityOnDelete()
        } catch (ex: Exception) {
            detailActivityViewImplementor.showError(ex.message!!)
        }
    }
}
package com.pravinkumarp.mvcdemo.view.detailactivity

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.pravinkumarp.mvcdemo.MainApplication
import com.pravinkumarp.mvcdemo.R
import com.pravinkumarp.mvcdemo.controller.DetailActivityController
import com.pravinkumarp.mvcdemo.model.MainModelImplementor
import com.pravinkumarp.mvcdemo.model.bean.Fruit
import com.pravinkumarp.mvcdemo.view.MainView

class DetailActivityViewImplementor(private val context: Context, private val fruitId: Int, private val viewGroup: ViewGroup?) : DetailActivityView {
    private val rootView: View = LayoutInflater.from(context).inflate(R.layout.activity_detail, viewGroup)

    private var mainModelImplementor: MainModelImplementor = MainModelImplementor(MainApplication.getDBHelper())
    private var detailActivityController: DetailActivityController = DetailActivityController(this, mainModelImplementor)

    private lateinit var etFruitName: EditText
    private lateinit var etFruitDescription: EditText
    private lateinit var btUpdateFruit: Button
    private lateinit var btDeleteFruit: Button

    override fun initView() {
        etFruitName = getRootView().findViewById(R.id.etFruitName)
        etFruitDescription = getRootView().findViewById(R.id.etFruitDescription)
        btUpdateFruit = getRootView().findViewById(R.id.btUpdateFruit)
        btDeleteFruit = getRootView().findViewById(R.id.btDeleteFruit)

        btUpdateFruit.setOnClickListener {
            detailActivityController.onFruitUpdateButtonClicked(Fruit(fruitId, etFruitName.text.toString(), etFruitDescription.text.toString()))
        }

        btDeleteFruit.setOnClickListener {
            detailActivityController.onFruitDeleteButtonClicked(Fruit(fruitId, etFruitName.text.toString(), etFruitDescription.text.toString()))
        }
    }

    override fun bindDataToView() {
        detailActivityController.onViewLoaded(fruitId)
    }

    override fun showSelectedFruit(fruit: Fruit) {
        etFruitName.setText(fruit.name)
        etFruitDescription.setText(fruit.description)
    }

    override fun updateViewOnUpdate(fruit: Fruit) {
        showSelectedFruit(fruit)
        Toast.makeText(context, "Updated fruit.", Toast.LENGTH_LONG).show()
    }

    override fun updateViewOnDelete(fruit: Fruit) {
        Toast.makeText(context, "Deleted ${fruit.name}.", Toast.LENGTH_LONG).show()
    }

    override fun navigateToMainActivityOnDelete() {
        (context as Activity).finish()
    }

    override fun showError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun getRootView(): View {
        return rootView
    }
}
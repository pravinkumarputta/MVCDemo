package com.pravinkumarp.mvcdemo.view.mainactivity

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pravinkumarp.mvcdemo.MainApplication
import com.pravinkumarp.mvcdemo.R
import com.pravinkumarp.mvcdemo.activities.DetailActivity
import com.pravinkumarp.mvcdemo.controller.MainActivityController
import com.pravinkumarp.mvcdemo.model.MainModelImplementor
import com.pravinkumarp.mvcdemo.model.bean.Fruit

class MainActivityViewImplementor(private val context: Context, private val viewGroup: ViewGroup?) : MainActivityView, MainActivityFruitListAdapter.OnFruitListItemClickListener {
    private var rootView: View = LayoutInflater.from(context).inflate(R.layout.activity_main, viewGroup)

    private var mainModelImplementor: MainModelImplementor = MainModelImplementor(MainApplication.getDBHelper())
    private var mainActivityController: MainActivityController = MainActivityController(this, mainModelImplementor)

    private lateinit var etFruitName: EditText
    private lateinit var etFruitDescription: EditText
    private lateinit var btAddFruit: Button
    private lateinit var recyclerViewFruits: RecyclerView

    override fun initView() {
        etFruitName = getRootView().findViewById(R.id.etFruitName)
        etFruitDescription = getRootView().findViewById(R.id.etFruitDescription)
        btAddFruit = getRootView().findViewById(R.id.btAddFruit)
        recyclerViewFruits = getRootView().findViewById(R.id.recyclerViewFruits)
        recyclerViewFruits.layoutManager = LinearLayoutManager(context)
        recyclerViewFruits.itemAnimator = DefaultItemAnimator()

        btAddFruit.setOnClickListener {
            mainActivityController.onAddFruitButtonClicked(Fruit(etFruitName.text.toString(), etFruitDescription.text.toString()))
        }
    }

    override fun bindDataToView() {
        mainActivityController.onViewLoaded()
    }

    override fun showAllFruits(fruits: ArrayList<Fruit>) {
        recyclerViewFruits.adapter = MainActivityFruitListAdapter(fruits, this)
    }

    override fun updateViewOnAddFruit(fruits: ArrayList<Fruit>) {
        showAllFruits(fruits)
        clearEditTexts()
    }

    override fun showError(message: String) {
        if (message == "No fruits to show.") {
            clearList()
        }
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun navigateToDetailsActivity(id: Int) {
        val intent = Intent(context, DetailActivity::class.java)
        intent.putExtra(DetailActivity.EXTRA_ID, id)
        context.startActivity(intent)
    }

    private fun clearEditTexts() {
        etFruitName.setText("")
        etFruitDescription.setText("")
    }

    private fun clearList() {
        recyclerViewFruits.adapter = MainActivityFruitListAdapter(ArrayList(), this)
    }

    override fun getRootView(): View {
        return rootView
    }

    override fun onFruitListItemClicked(fruit: Fruit) {
        mainActivityController.onFruitListItemClickListener(fruit.id!!)
    }
}
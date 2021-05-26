package com.pravinkumarp.mvcdemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pravinkumarp.mvcdemo.view.detailactivity.DetailActivityViewImplementor

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "EXTRA_ID"
    }

    private lateinit var detailActivityViewImplementor: DetailActivityViewImplementor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fruitId = intent.getIntExtra(EXTRA_ID, -1)
        detailActivityViewImplementor = DetailActivityViewImplementor(this, fruitId, null)
        setContentView(detailActivityViewImplementor.getRootView())
        detailActivityViewImplementor.initView()
    }

    override fun onResume() {
        super.onResume()
        detailActivityViewImplementor.bindDataToView()
    }
}
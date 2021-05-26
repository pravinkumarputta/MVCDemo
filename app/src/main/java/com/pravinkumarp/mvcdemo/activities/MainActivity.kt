package com.pravinkumarp.mvcdemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pravinkumarp.mvcdemo.view.mainactivity.MainActivityViewImplementor

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivityViewImplementor: MainActivityViewImplementor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityViewImplementor = MainActivityViewImplementor(this, null)
        setContentView(mainActivityViewImplementor.getRootView())
        mainActivityViewImplementor.initView()
    }

    override fun onResume() {
        super.onResume()
        mainActivityViewImplementor.bindDataToView()
    }
}
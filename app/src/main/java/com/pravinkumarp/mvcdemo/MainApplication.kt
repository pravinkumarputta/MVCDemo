package com.pravinkumarp.mvcdemo

import android.app.Application
import com.pravinkumarp.mvcdemo.model.db.DBHelper

class MainApplication: Application() {

    companion object {
        private lateinit var dbHelper: DBHelper
        fun getDBHelper(): DBHelper {
            return dbHelper
        }
    }

    override fun onCreate() {
        super.onCreate()

        dbHelper = DBHelper(applicationContext)
    }
}
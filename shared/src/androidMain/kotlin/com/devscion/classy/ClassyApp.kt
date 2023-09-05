package com.devscion.classy

import android.app.Application
import com.devscion.classy.data.db.ClassyDBFactory

class ClassyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        ClassyDBFactory.context = applicationContext
    }

}
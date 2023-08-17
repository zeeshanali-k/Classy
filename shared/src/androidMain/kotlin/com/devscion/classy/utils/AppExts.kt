package com.devscion.classy.utils

import android.util.Log


actual infix fun Exception.logAll(tag:String){
    Log.d(tag, "logAll: ${cause}")
    Log.d(tag, "logAll: ${localizedMessage}")
    Log.d(tag, "logAll: ${message}")
}
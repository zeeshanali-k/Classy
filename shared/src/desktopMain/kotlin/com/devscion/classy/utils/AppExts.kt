package com.devscion.classy.utils

actual infix fun Exception.logAll(tag:String){

    printStackTrace()
    print("$tag: $cause")
    print("$tag : $message")
}
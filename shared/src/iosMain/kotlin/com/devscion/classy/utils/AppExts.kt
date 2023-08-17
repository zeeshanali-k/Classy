package com.devscion.classy.utils

import platform.Foundation.NSLog


actual infix fun Exception.logAll(tag:String){

    printStackTrace()
    print("$tag: $cause")
    print("$tag : $message")
    //ios logging
    NSLog("$tag: $cause")
    NSLog("$tag: $message")
}
package com.devscion.classy.utils

actual infix fun Exception.logAll(tag: String) {
    console.log("$tag : $message")
    console.log("$tag : $cause")
}
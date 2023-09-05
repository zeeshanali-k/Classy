package com.devscion.classy.utils

import io.ktor.util.date.GMTDate


fun GMTDate.toAppDateFormat() : String{
    return "${dayOfMonth}/${month}/${year} ${hours}:${minutes}"
}

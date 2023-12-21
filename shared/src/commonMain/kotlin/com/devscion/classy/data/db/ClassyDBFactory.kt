package com.devscion.classy.data.db

import app.cash.sqldelight.db.SqlDriver
import com.devscion.classy.db.Classy


expect object ClassyDBFactory {
    fun createDriver(): SqlDriver?
}

fun createDatabase(): Classy {
    return Classy(
        ClassyDBFactory.createDriver()!!
    )
}
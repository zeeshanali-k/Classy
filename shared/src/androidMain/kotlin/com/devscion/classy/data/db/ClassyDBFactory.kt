package com.devscion.classy.data.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.devscion.classy.db.Classy

actual object ClassyDBFactory {
    lateinit var context : Context
    actual fun createDriver(): SqlDriver? {
        return AndroidSqliteDriver(Classy.Schema, context, "classy.db")
    }
}

package com.devscion.classy.data.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.devscion.classy.db.Classy


actual object ClassyDBFactory {
    actual fun createDriver(): SqlDriver? {
        return NativeSqliteDriver(Classy.Schema, "classy.db")
    }
}


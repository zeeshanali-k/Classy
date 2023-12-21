package com.devscion.classy.data.db

import app.cash.sqldelight.db.SqlDriver

actual object ClassyDBFactory {
    actual fun createDriver(): SqlDriver? {
        return null
    }
}
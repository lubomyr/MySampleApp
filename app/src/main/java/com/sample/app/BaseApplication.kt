package com.sample.app

import android.app.Application
import com.sample.app.db.greendao.DaoMaster
import com.sample.app.db.greendao.DaoSession

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val helper = DaoMaster.DevOpenHelper(this, if (ENCRYPTED) "user-db-encrypted" else "user-db")
        val db = helper.writableDb
        daoSession = DaoMaster(db).newSession()
    }

    companion object {
        /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher.  */
        val ENCRYPTED = false

        var daoSession: DaoSession? = null
            private set
    }
}

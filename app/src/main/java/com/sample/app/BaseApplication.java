package com.sample.app;

import android.app.Application;

import com.sample.app.db.greendao.DaoMaster;
import com.sample.app.db.greendao.DaoSession;

import org.greenrobot.greendao.database.Database;

public class BaseApplication extends Application {
    /** A flag to show how easily you can switch from standard SQLite to the encrypted SQLCipher. */
    public static final boolean ENCRYPTED = false;

    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, ENCRYPTED ? "user-db-encrypted" : "user-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}

package com.sample.app.db.greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import com.sample.app.entity.Customer;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CUSTOMER".
*/
public class CustomerDao extends AbstractDao<Customer, Long> {

    public static final String TABLENAME = "CUSTOMER";

    /**
     * Properties of entity Customer.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property City = new Property(2, String.class, "city", false, "CITY");
        public final static Property Country = new Property(3, String.class, "country", false, "COUNTRY");
    }


    public CustomerDao(DaoConfig config) {
        super(config);
    }
    
    public CustomerDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CUSTOMER\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"CITY\" TEXT," + // 2: city
                "\"COUNTRY\" TEXT);"); // 3: country
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CUSTOMER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, Customer entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(3, city);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(4, country);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, Customer entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getId());
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(3, city);
        }
 
        String country = entity.getCountry();
        if (country != null) {
            stmt.bindString(4, country);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.getLong(offset + 0);
    }    

    @Override
    public Customer readEntity(Cursor cursor, int offset) {
        Customer entity = new Customer( //
            cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // city
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3) // country
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, Customer entity, int offset) {
        entity.setId(cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setCity(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setCountry(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(Customer entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(Customer entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(Customer entity) {
        throw new UnsupportedOperationException("Unsupported for entities with a non-null key");
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}

package com.sample.app.repository

import android.util.Log

import com.sample.app.BaseApplication
import com.sample.app.db.greendao.CustomerDao
import com.sample.app.entity.Customer
import java.util.concurrent.atomic.AtomicLong

object CustomerRepository {
    private val sId = AtomicLong()

    private val dao: CustomerDao
        get() = BaseApplication.daoSession!!.customerDao

    fun saveAll(itemList: List<Customer>) {
        val dao = dao

        var oldItemList: List<Customer>
        var old: Customer
        for (item in itemList) {
            oldItemList = dao.queryBuilder()
                    .where(CustomerDao.Properties.Name.eq(item.name)).list()
            if (!oldItemList.isEmpty()) {
                old = oldItemList[0]
                item.id = old.id
                dao.update(item)
                sId.incrementAndGet()
            } else {
                item.id = sId.getAndIncrement()
                insert(item, dao)
            }
        }
    }

    private fun insert(item: Customer, dao: CustomerDao) {
        try {
            dao.insert(item)
        } catch (throwable: Throwable) {
            Log.e("dao.insert(Customer)", throwable.toString())
            item.id = sId.incrementAndGet()
            insert(item, dao)
        }

    }

    fun search(searchStr: String): List<Customer> {
        return dao.queryBuilder().where(
                CustomerDao.Properties.Name.like("%$searchStr%")).list()
    }

    val all: List<Customer>
        get() = dao.loadAll()
}


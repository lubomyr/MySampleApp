package com.sample.app.repository;

import android.util.Log;

import com.sample.app.BaseApplication;
import com.sample.app.db.greendao.CustomerDao;
import com.sample.app.entity.Customer;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CustomerRepository {
    private static AtomicLong sId = new AtomicLong();

    private static CustomerDao getDao() {
        return BaseApplication.getDaoSession().getCustomerDao();
    }

    public static void saveAll(List<Customer> itemList) {
        CustomerDao dao = getDao();

        List<Customer> oldItemList;
        Customer old;
        for (Customer item : itemList) {
            oldItemList = dao.queryBuilder()
                    .where(CustomerDao.Properties.Name.eq(item.getName())).list();
            if (!oldItemList.isEmpty()) {
                old = oldItemList.get(0);
                item.setId(old.getId());
                dao.update(item);
                sId.incrementAndGet();
            } else {
                item.setId(sId.getAndIncrement());
                insert(item, dao);
            }
        }
    }

    private static void insert(Customer item, CustomerDao dao) {
        try {
            dao.insert(item);
        } catch (Throwable throwable) {
            Log.e("dao.insert(Customer)", throwable.toString());
            item.setId(sId.incrementAndGet());
            insert(item, dao);
        }
    }

    public static List<Customer> search(String searchStr) {
        return getDao().queryBuilder().where(
                CustomerDao.Properties.Name.like("%" + searchStr + "%")).list();
    }

    public static List<Customer> getAll() {
        return getDao().loadAll();
    }
}


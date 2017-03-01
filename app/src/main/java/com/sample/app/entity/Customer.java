package com.sample.app.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Customer {
    @Id (autoincrement = true)
    private long id;

    @Expose
    @SerializedName("Name")
    private String name;

    @Expose
    @SerializedName("City")
    private String city;

    @Expose
    @SerializedName("Country")
    private String country;

    public Customer(String name, String city, String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Generated(hash = 347986795)
    public Customer(long id, String name, String city, String country) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Generated(hash = 60841032)
    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

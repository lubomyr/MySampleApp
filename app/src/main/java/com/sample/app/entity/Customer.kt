package com.sample.app.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.realm.annotations.PrimaryKey
import org.greenrobot.greendao.annotation.Entity
import org.greenrobot.greendao.annotation.Generated
import org.greenrobot.greendao.annotation.Id

@Entity
class Customer {
    @Id(autoincrement = true)
    @PrimaryKey
    var id: Long = 0

    @Expose
    @SerializedName("Name")
    var name: String? = null

    @Expose
    @SerializedName("City")
    var city: String? = null

    @Expose
    @SerializedName("Country")
    var country: String? = null

    constructor(name: String, city: String, country: String) {
        this.name = name
        this.city = city
        this.country = country
    }

    @Generated(hash = 347986795)
    constructor(id: Long, name: String, city: String, country: String) {
        this.id = id
        this.name = name
        this.city = city
        this.country = country
    }

    @Generated(hash = 60841032)
    constructor() {
    }
}

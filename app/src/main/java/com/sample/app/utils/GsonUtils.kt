package com.sample.app.utils

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonUtils {

    internal var prettyGson: Gson? = null
    internal var gson: Gson? = null

    @JvmOverloads
    fun getGson(pretty: Boolean = true): Gson? {
        if (pretty) {
            if (prettyGson == null) {
                synchronized(GsonUtils::class.java) {
                    val builder = GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting()
                    prettyGson = builder.create()
                }
            }
            return prettyGson
        } else {
            if (gson == null) {
                synchronized(GsonUtils::class.java) {
                    gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
                }
            }
            return gson
        }
    }
}

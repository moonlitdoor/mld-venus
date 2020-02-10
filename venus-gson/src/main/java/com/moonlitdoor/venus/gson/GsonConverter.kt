package com.moonlitdoor.venus.gson

import com.google.gson.Gson
import com.moonlitdoor.venus.hawke.converter.Converter
import com.moonlitdoor.venus.serialization.Serializer

class GsonConverter(private val gson: Gson = Gson()) : Serializer {

    override fun <T> serialize(value: T): String = gson.toJson(value)

    override fun <T> deserialize(value: String?, type: Class<T>): T? = gson.fromJson(value, type)
}

package com.moonlitdoor.venus.serialization

class ToStringSerializer : Serializer {

    override fun <T> serialize(t: T): String = t.toString()

    override fun <T> deserialize(value: String?, type: Class<T>): T? = type.newInstance()

}
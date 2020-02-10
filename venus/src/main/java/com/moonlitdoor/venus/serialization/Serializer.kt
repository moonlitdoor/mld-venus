package com.moonlitdoor.venus.serialization

interface Serializer {

    fun <T> serialize(t: T): String

    fun <T> deserialize(value: String?, type: Class<T>): T?

}

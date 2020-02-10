package com.moonlitdoor.venus

import com.moonlitdoor.venus.encryption.Encrypter
import com.moonlitdoor.venus.encryption.PlainTextEncrypter
import com.moonlitdoor.venus.extensions.ignore
import com.moonlitdoor.venus.serialization.Serializer


object Venus {

    private lateinit var serializer: Serializer
    private lateinit var encrypter: Encrypter
    private val cache = LRUCache<String, String?>(128)

    fun init(block: Builder.() -> Unit = {}) {
        val builder = Builder()
        builder.block()
        builder.serializer?.let {
            this.serializer = it
        } ?: kotlin.run { }
        builder.encrypter?.let {
            this.encrypter = it
        } ?: kotlin.run {
            this.encrypter = PlainTextEncrypter()
        }
    }

    class Builder {
        var serializer: Serializer? = null
        var encrypter: Encrypter? = null
    }

    fun <T : Any?> put(key: String, value: T): Unit =
        cache.put(key, encrypter.encrypt(serializer.serialize(value))).ignore()

    fun <T : Any> get(key: String, type: Class<T>): T? =
        serializer.deserialize(encrypter.decrypt(cache[key]), type)

    operator fun <T> get(key: String, defaultValue: T): T = defaultValue

    fun count(): Long = cache.size.toLong()

    fun deleteAll(): Boolean {
        cache.clear()
        return true
    }


    fun delete(key: String): Boolean {
        cache.remove(key)
        return true
    }


    operator fun contains(key: String): Boolean = cache.contains(key)

}

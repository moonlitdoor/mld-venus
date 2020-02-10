package com.moonlitdoor.venus

import com.moonlitdoor.venus.encryption.PlainTextEncrypter
import com.moonlitdoor.venus.serialization.ToStringSerializer
import org.junit.Assert.assertEquals
import org.junit.Test

class VenusTest {


    @Test
    fun getCache() {
        Venus.init {
            encrypter = PlainTextEncrypter()
            serializer = ToStringSerializer()
        }
        assertEquals(0, Venus.count())
        Venus.put("dude", Person("bob", 23))
        assertEquals(1, Venus.count())
    }

    @Test
    fun get() {
    }

    @Test
    fun count() {
    }

    @Test
    fun deleteAll() {
    }

    @Test
    fun delete() {
    }

    @Test
    fun contains() {
    }
}
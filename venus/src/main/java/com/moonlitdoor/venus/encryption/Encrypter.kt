package com.moonlitdoor.venus.encryption

interface Encrypter {

    fun encrypt(plainText: String): String

    fun decrypt(encryptedValue: String?) : String?

}
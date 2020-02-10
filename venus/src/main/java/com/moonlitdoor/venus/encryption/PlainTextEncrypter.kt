package com.moonlitdoor.venus.encryption

class PlainTextEncrypter : Encrypter {

    override fun encrypt(plainText: String): String  = plainText

    override fun decrypt(encryptedValue: String?): String? = encryptedValue
}
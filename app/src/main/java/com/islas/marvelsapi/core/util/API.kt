package com.islas.marvelsapi.core.util

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

object API {
    const val BASE_URL = "https://gateway.marvel.com/"
    const val CHARACTERS = "/v1/public/characters"
    const val COMICS = "/v1/public/comics"
    const val SERIES = "/v1/public/series"
    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
    const val API_KEY = "4366d1c510380cd3365c33278579efe1"
    private const val PRIVATE_KEY = "0dc61c8bdc47cf351a5d8f6f8f0b8b7ff4bae786"

    fun hashedKey(): String {
        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(input.toByteArray())).toString(16).padStart(32, '0')
    }
}

package com.dso.ext

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * 获取 String md5 值
 */
fun String.md5(): String {
    if (this.isEmpty()) {
        return ""
    }
    try {
        val md5 = MessageDigest.getInstance("MD5")
        val bytes: ByteArray = md5.digest(this.toByteArray())
        val result = StringBuilder()
        for (b in bytes) {
            var temp = Integer.toHexString(b and 0xff)
            if (temp.length == 1) {
                temp = "0$temp"
            }
            result.append(temp)
        }
        return result.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}

infix fun Byte.and(mask: Int): Int = toInt() and mask

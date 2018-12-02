package com.haduken.japan.marvelaac.extensions

import java.security.MessageDigest

inline fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val hashInBytes = md.digest(this.toByteArray())
    val sb = StringBuilder()
    for (b in hashInBytes) {
        sb.append(String.format("%02x", b))
    }
    return sb.toString()
}
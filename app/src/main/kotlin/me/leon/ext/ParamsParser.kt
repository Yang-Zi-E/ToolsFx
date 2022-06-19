package me.leon.ext

import java.math.BigInteger

fun String.parseRsaParams() =
    replace("\"|'", "").split("\n|\r\n".toRegex()).filter { it.contains("[=:：]".toRegex()) }.fold(
        mutableMapOf<String, BigInteger>()
    ) { acc, s ->
        println(this)
        println("__________")
        acc.apply {
            with(s.split("\\s*[=:：]\\s*".toRegex())) {
                println(this)
                acc[this[0].lowercase()] =
                    this[1].takeUnless { it.startsWith("0x", true) }?.toBigInteger()
                        ?: this[1].substring(2).toBigInteger(16)
            }
        }
    }
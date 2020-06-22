package com.honwon.pricecomparision

import org.junit.Test

import org.junit.Assert.*
import java.net.URLEncoder

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val marttt = 3000
        val i = 5
        val onlinee = 2400
        val post = 2500
        val a = "${((marttt * i) / (onlinee * i + 2500) - 1) * 100}%"

        println(((marttt * i) / (onlinee * i + 2500) - 1))
        val c  = marttt*i
        val d = onlinee*i
        println(c/d.toFloat())

        println(a)
    }
}
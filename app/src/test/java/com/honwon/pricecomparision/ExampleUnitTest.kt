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
        val a = ""

        val b = URLEncoder.encode(a,"euc-kr")
        val c = URLEncoder.encode(a,"utf-8")
        println(b)
        println(c)
    }
}
package com.anushka.circlecalc

import org.junit.Before
import org.junit.Test

class MyCalcTest {

    private lateinit var myCalc: MyCalc


    @Before
    fun setUp() {
        myCalc = MyCalc()
    }

    @Test
    fun calculateCircumference_radiusGiven_returnsCorrectResult() {

        val result = myCalc.calculateCircumference(2.1)
        assert(result==13.188)

    }

    @Test
    fun calculateArea_radiusGiven_returnsCorrectResult() {

        val result = myCalc.calculateArea(2.1)
        assert(result==13.8474)

    }
}
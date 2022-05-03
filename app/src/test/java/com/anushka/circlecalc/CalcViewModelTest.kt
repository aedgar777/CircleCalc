package com.anushka.circlecalc

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CalcViewModelTest {

    private lateinit var calcViewModel: CalcViewModel
    private lateinit var calculations: Calculations

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()


    @Before
    fun setUp() {
        calculations = Mockito.mock(Calculations::class.java)// Creates mock instance of dependency class
        Mockito.`when`(calculations.calculateArea(2.1)).thenReturn(13.8474)
        Mockito.`when`(calculations.calculateCircumference(1.0)).thenReturn(6.28)// Set value to be returned from given input
        calcViewModel = CalcViewModel(calculations)// Passes mock instance of class to viewmodel
    }

    @Test
    fun calculateArea_radiusSent_updateLiveData() { // Tests the result as it is returned from viewModel, not the direct result of the function therein
        calcViewModel.calculateArea(2.1)
        val result = calcViewModel.areaValue.value

        assert(result== "13.8474")
    }


    @Test
    fun calculateCircumference_radiusSent_updateLiveData() { // Tests the result as it is returned from viewModel, not the direct result of the function therein
        calcViewModel.calculateCircumference(1.0)
        val result = calcViewModel.circumferenceValue.value

        assert(result== "6.28")
    }
}
package com.sem.exchangerate.domain.useCase

import androidx.lifecycle.MutableLiveData
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.domain.repository.ExchangeRateCall
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class ExchangeRateUseCaseTest {

    val userRepository = mock<ExchangeRateCall>()

    @Test
    fun loadExchangeRate() {

        val testLiveData = listOf<ExchangeRateModel>(ExchangeRateModel(0, "name", 0.34), ExchangeRateModel(1, "name2", 0.35))

        val liveData = MutableLiveData<List<ExchangeRateModel>>()
        liveData.value = testLiveData
        Mockito.`when`(userRepository.loadCurrency()).thenReturn(liveData)

        val useCase = ExchangeRateUseCase(userRepository)
        val actual = useCase.loadExchangeRate()

        val liveData2 = MutableLiveData<List<ExchangeRateModel>>()
        liveData2.value = listOf<ExchangeRateModel>(ExchangeRateModel(0, "name", 0.34), ExchangeRateModel(1, "name2", 0.35))

        Assert.assertEquals(liveData2, actual)
    }

    @Test
    fun test1() {

        Assert.assertEquals(4, 2 + 2)

    }

}


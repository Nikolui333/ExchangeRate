package com.sem.exchangerate.data.dataSourceIMPL

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sem.exchangerate.data.api.ApiClient
import com.sem.exchangerate.data.dataSource.ApiDataSource
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSourceIMPL(private val exchangeRateDataSource: ExchangeRateDataSource):
    ApiDataSource {

    override fun startMigration (context: Context) {

        val call = ApiClient.instance?.api?.loadExchangeRateApi()
        call?.enqueue(object: Callback<ExchangeRateResponseModel> {
            override fun onResponse(
                call: Call<ExchangeRateResponseModel>,
                response: Response<ExchangeRateResponseModel>
            ) {

                Log.d("ApiDataSource", "onResponse status: ${response.code()}")
                // создаём список
                var loadExchangeRate: ExchangeRateResponseModel? = null
              //  loadExchangeRate?.clear()
                // получаем данные с сервера
                loadExchangeRate = (response.body() as ExchangeRateResponseModel?)!!


                exchangeRateDataSource.insert(ExchangeRateModel(1,"AUD", loadExchangeRate.rates?.AUD.toString()))
                exchangeRateDataSource.insert(ExchangeRateModel(2,"EUR", loadExchangeRate.rates?.EUR.toString()))
                exchangeRateDataSource.insert(ExchangeRateModel(3,"JPY", loadExchangeRate.rates?.JPY.toString()))
                exchangeRateDataSource.insert(ExchangeRateModel(4,"MDL", loadExchangeRate.rates?.MDL.toString()))
                exchangeRateDataSource.insert(ExchangeRateModel(5,"RUB", loadExchangeRate.rates?.RUB.toString()))



                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ExchangeRateResponseModel>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()
                Log.e("ApiDataSource2", "onFailure", t)
            }
        })

    }

}
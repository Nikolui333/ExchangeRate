package com.sem.exchangerate.data.dataSourceIMPL

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sem.exchangerate.data.dataSource.ApiDataSource
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.data.models.ExchangeRateResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSourceIMPL(private val exchangeRateDataSource: ExchangeRateDataSource):
    ApiDataSource {

    companion object {
        var call: Call<ExchangeRateResponseModel>? = null
    }

    override fun startMigration (context: Context, dataApi: Call<ExchangeRateResponseModel>?) {

        call = dataApi
            // ApiClient.instance?.api?.loadExchangeRateApiUSD()
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

                exchangeRateDataSource.insert(ExchangeRateModel(1,"EUR", loadExchangeRate.rates?.EUR))
                exchangeRateDataSource.insert(ExchangeRateModel(2,"AUD", loadExchangeRate.rates?.AUD))
                exchangeRateDataSource.insert(ExchangeRateModel(3,"RUB", loadExchangeRate.rates?.RUB))
                exchangeRateDataSource.insert(ExchangeRateModel(4,"JPY", loadExchangeRate.rates?.JPY))
                exchangeRateDataSource.insert(ExchangeRateModel(5,"MDL", loadExchangeRate.rates?.MDL))

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ExchangeRateResponseModel>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()
                Log.e("ApiDataSource2", "onFailure", t)
            }
        })

    }

}
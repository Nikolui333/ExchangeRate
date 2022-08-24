package com.sem.exchangerate.data.dataSourceIMPL

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.sem.exchangerate.data.api.ApiClient
import com.sem.exchangerate.data.dataSource.ApiDataSource
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.models.ExchangeRateApiModel
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
                // создаём список
                var loadExchangeRate: ExchangeRateResponseModel? = null
                // очищаем массив
              //  loadExchangeRate?.clear()
                // получаем данные с сервера
                loadExchangeRate = (response.body() as ExchangeRateResponseModel?)!!


                exchangeRateDataSource.insert(ExchangeRateModel( 1, loadExchangeRate.rates?.AUD.toString(), loadExchangeRate.rates?.EUR.toString(), loadExchangeRate.rates?.JPY.toString(),
                        loadExchangeRate.rates?.MDL.toString(),loadExchangeRate.rates?.RUB.toString()))


                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ExchangeRateResponseModel/*ArrayList<ExchangeRateApiModel>*/>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()
                Log.e("ApiDataSource", "onFailure", t)
            }
        })

    }

}
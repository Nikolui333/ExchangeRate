package com.sem.exchangerate.data.dataSourceIMPL

import android.content.Context
import android.widget.Toast
import com.sem.exchangerate.data.api.ApiClient
import com.sem.exchangerate.data.dataSource.ApiDataSource
import com.sem.exchangerate.data.dataSource.ExchangeRateDataSource
import com.sem.exchangerate.data.models.ExchangeRateApiModel
import com.sem.exchangerate.data.models.ExchangeRateModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiDataSourceIMPL(private val exchangeRateDataSource: ExchangeRateDataSource):
    ApiDataSource {

    override fun startMigration (context: Context) {

        // вызываем ApiClient в котором содержится ссылка для получения данных
        val call = ApiClient.instance?.api?.loadExchangeRateApi()
        call?.enqueue(object: Callback<ArrayList<ExchangeRateApiModel>> { // MedicationsApiModel идентична таблице базы данных на сервере
            override fun onResponse(
                call: Call<ArrayList<ExchangeRateApiModel>>,
                response: Response<ArrayList<ExchangeRateApiModel>>
            ) {
                // создаём список
                var loadExchangeRate: ArrayList<ExchangeRateApiModel>? = null
                // очищаем массив
                loadExchangeRate?.clear()
                // получаем данные с сервера
                loadExchangeRate = (response.body() as ArrayList<ExchangeRateApiModel>?)!!

                // помещение данных в локальную базу данных
                for (audit in loadExchangeRate) {

                    audit.id?.let {
                        ExchangeRateModel( // MedicationsModel - локальная таблица базы данных
                            it,
                            audit.AUD.toString(),
                            audit.EUR.toString(),
                            audit.JPY.toString(),
                            audit.MDL.toString(),
                            audit.RUB.toString(),

                        )
                    }?.let {
                        exchangeRateDataSource.insert(
                            it
                        )
                    }

                }

                Toast.makeText(context, "ЗАГРУЗКА", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<ArrayList<ExchangeRateApiModel>>, t: Throwable) {
                Toast.makeText(context, "ОШИБКА! ВКЛЮЧИТЕ ИНТЕРНЕТ!", Toast.LENGTH_SHORT).show()

            }
        })

    }

}
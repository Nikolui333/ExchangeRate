package com.sem.exchangerate.data.dataSourceIMPL

import android.content.Context
import androidx.lifecycle.LiveData
import com.sem.exchangerate.data.dataSource.CurrencyDataSource
import com.sem.exchangerate.data.localDB.CurrencyDao
import com.sem.exchangerate.data.models.CurrencyModel
import com.sem.exchangerate.data.models.ExchangeRateModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CurrencyDataSourceIMPL(private val dao: CurrencyDao) : CurrencyDataSource {

    override fun insert(currencyModel: CurrencyModel) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.insert(currencyModel)}
    }

/*    override fun startMigration(context: Context) {
        TODO("Not yet implemented")
    }*/

    override fun loadCurrency(): LiveData<List<CurrencyModel>> {
        return dao.getCurrency()
    }

    override suspend fun clear() {
        CoroutineScope(Dispatchers.IO).launch {
            dao.clear()}
    }


}
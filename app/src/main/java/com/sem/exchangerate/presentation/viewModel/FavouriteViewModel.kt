package com.sem.exchangerate.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.domain.useCase.FavouriteUseCase
import kotlinx.coroutines.launch

class FavouriteViewModel(private val favouriteUseCase: FavouriteUseCase) : ViewModel() {

    fun startInsert(name:String, exchange:String, idFavourite:String) {
        insert(
            FavouriteModel(0, name, exchange, idFavourite)
        )
    }

    private fun insert(favouriteModel: FavouriteModel) = viewModelScope.launch{
        favouriteUseCase.insert(favouriteModel)
    }

    val loadCurrencyFromFavourite = favouriteUseCase.loadCurrencyFromFavourite()

    // метод loadCurrencyToCardFromFavourite проверяет, есть ли валюта в разделе избранное
    fun loadCurrencyToCardFromFavourite(idProduct:String): LiveData<List<FavouriteModel>> {
        return favouriteUseCase.loadCurrencyToCardFromFavourite(idProduct)
    }
    // методо deleteCurrencyFromFavourite удаляет выбранную валюту из вкладки избранное
    fun deleteCurrencyFromFavourite(idProduct:Int) = viewModelScope.launch{

        favouriteUseCase.deleteCurrencyFromFavourite(idProduct)
    }
    // метод deleteCurrencyToCardFromFavourite уибрает добавление в избранное выбранной валюты, на вкладке всех валют
    fun deleteCurrencyToCardFromFavourite(idProduct:String) = viewModelScope.launch{

        favouriteUseCase.deleteCurrencyToCardFromFavourite(idProduct)
    }


}
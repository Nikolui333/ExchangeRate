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
    // viewModelScope прекращает работу внутри ViewModel (в данном случае в методе insert) в случае, если пользователь покинул экран
    // метод insert отвечает за добавление нового вида товара в корзину
    private fun insert(favouriteModel: FavouriteModel) = viewModelScope.launch{
        favouriteUseCase.insert(favouriteModel)
    }

    // так как в методе loadMedicineFromCard() класса CardUseCase нет принимаемых значений, вместо создания метода,
    // возвращающего метод loadMedicineFromCard(), можно присвоить его переменной
    val loadMedicineFromCard = favouriteUseCase.loadMedicineFromCard()

    // LiveData хранит данные, которые можно получать каждый раз, когда что-то меняется
    // метод loadMedicineToCardFromCardProduct проверяет, есть ли товар в корзине
    fun loadMedicineToCardFromCardProduct(idProduct:String): LiveData<List<FavouriteModel>> {
        return favouriteUseCase.loadMedicineToCardFromCardProduct(idProduct)
    }
    // методо deleteProductFromCard удаляет выбранный вид лекарства из корзины во вкладке корзины
    fun deleteProductFromCard(idProduct:Int) = viewModelScope.launch{

        favouriteUseCase.deleteProductFromCard(idProduct)
    }
    // метод deleteProductToCardFromCardProduct удаляет выбранный вид лекарства из корзины на вкладке со списком препаратов
    fun deleteProductToCardFromCardProduct(idProduct:String) = viewModelScope.launch{

        favouriteUseCase.deleteProductToCardFromCardProduct(idProduct)
    }


}
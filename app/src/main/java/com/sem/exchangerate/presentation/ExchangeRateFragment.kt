package com.sem.exchangerate.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.exchangerate.R
import com.sem.exchangerate.databinding.FragmentExchangeRateBinding
import com.sem.exchangerate.presentation.viewModel.ExchangeRateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.presentation.viewModel.FavouriteViewModel

class ExchangeRateFragment : Fragment() {

    private var binding: FragmentExchangeRateBinding? = null
    private var exchangeRateAdapter : ExchangeRateAdapter? = null
    private val exchangeRateViewModel : ExchangeRateViewModel? by viewModel()
    private val favouriteViewModel: FavouriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exchange_rate, container, false)

        initRecyclerExchangeRate()
        loadExchangeRate()

        return binding?.root
    }

    private fun initRecyclerExchangeRate(){

        binding?.exchangeRateRV?.layoutManager =
            LinearLayoutManager(context)
        exchangeRateAdapter = ExchangeRateAdapter({ exchangeRateModel: ExchangeRateModel ->
            addToCard(
                exchangeRateModel
            )
        }, { exchangeRateModel: ExchangeRateModel ->
            removeFromCard(
                exchangeRateModel
            )
            // отображение кнопок добавления или удаления товара
        }, { idProduct:Int, addToBasket: AppCompatImageButton,
             removeFromBasket: AppCompatImageButton ->
            loadMedicineToCardFromCardProduct(
                idProduct, addToBasket, removeFromBasket
            )
        })

        binding?.exchangeRateRV?.adapter = exchangeRateAdapter
    }

    private fun loadExchangeRate(){

        exchangeRateViewModel?.loadExchange?.observe(viewLifecycleOwner, Observer {

            exchangeRateAdapter?.setList(it)
            exchangeRateAdapter?.notifyDataSetChanged()
        })

    }

    // добавление товара в корзину
    private fun addToCard(exchangeRateModel: ExchangeRateModel) {
        favouriteViewModel.startInsert(exchangeRateModel.name,
            exchangeRateModel.exchange,
            exchangeRateModel.id.toString())
    }

    // удаление товара из корзины
    private fun removeFromCard(exchangeRateModel: ExchangeRateModel) {
        favouriteViewModel.deleteProductToCardFromCardProduct(exchangeRateModel.id.toString())
    }

    // проверяем, есть ли товар в корзине и узнаём его колличество
    private fun loadMedicineToCardFromCardProduct (idProduct:Int, addToBasket: AppCompatImageButton,
                                                   removeFromBasket: AppCompatImageButton
    ){
        // передаём id, который приходит из адаптера
        favouriteViewModel.loadMedicineToCardFromCardProduct(idProduct.toString()).observe(viewLifecycleOwner, Observer {

            // в переменную count получаем колличество товара
            val count = it.count() // it - это неявное имя одного параметра в лямбда-функции

            // если колличество больше нуля, убрать кнопку добавления и отобразить кнопку удаления
            if (count>0) {
                addToBasket.visibility = View.GONE
                removeFromBasket.visibility = View.VISIBLE
            }
            else {
                addToBasket.visibility = View.VISIBLE
                removeFromBasket.visibility = View.GONE }
        })

    }

}
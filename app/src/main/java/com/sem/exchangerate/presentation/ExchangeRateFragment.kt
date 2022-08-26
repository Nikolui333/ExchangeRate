package com.sem.exchangerate.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
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

        binding?.sort?.setOnClickListener {

            exchangeRateViewModel?.getSortCurrencyAlphabetAscending?.observe(
                viewLifecycleOwner, Observer {
                    exchangeRateAdapter?.setList(it)
                    exchangeRateAdapter?.notifyDataSetChanged()
                }
            )
        }

        return binding?.root
    }

    private fun initRecyclerExchangeRate(){

        binding?.exchangeRateRV?.layoutManager =
            LinearLayoutManager(context)
        exchangeRateAdapter = ExchangeRateAdapter({ exchangeRateModel: ExchangeRateModel ->
            addToFavourite(
                exchangeRateModel
            )
        }, { exchangeRateModel: ExchangeRateModel ->
            removeFromFavourite(
                exchangeRateModel
            )
            // отображение кнопок добавления или удаления
        }, { idProduct:Int, addToBasket: AppCompatImageButton,
             removeFromBasket: AppCompatImageButton ->
            loadCurrencyToCardFromFavourite(
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

    // добавление в избранное
    private fun addToFavourite(exchangeRateModel: ExchangeRateModel) {
        favouriteViewModel.startInsert(exchangeRateModel.name,
            exchangeRateModel.exchange,
            exchangeRateModel.id.toString())
    }

    // удаление из избранного
    private fun removeFromFavourite(exchangeRateModel: ExchangeRateModel) {
        favouriteViewModel.deleteCurrencyToCardFromFavourite(exchangeRateModel.id.toString())
    }

    // проверка, есть ли валюта в разделе избранное
    private fun loadCurrencyToCardFromFavourite (idProduct:Int, addToBasket: AppCompatImageButton,
                                                   removeFromBasket: AppCompatImageButton
    ){
        favouriteViewModel.loadCurrencyToCardFromFavourite(idProduct.toString()).observe(viewLifecycleOwner, Observer {

            val count = it.count()

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
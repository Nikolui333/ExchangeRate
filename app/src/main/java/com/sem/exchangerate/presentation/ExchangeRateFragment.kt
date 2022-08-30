package com.sem.exchangerate.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
    private var spinner : Spinner? = null

    private var adapter: ArrayAdapter<String>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exchange_rate, container, false)

        initRecyclerExchangeRate()
        loadExchangeRate()

        binding?.sortAlphabetAscending?.setOnClickListener {

            exchangeRateViewModel?.getSortCurrencyAlphabetAscending?.observe(
                viewLifecycleOwner, Observer {
                    exchangeRateAdapter?.setList(it)
                    exchangeRateAdapter?.notifyDataSetChanged()
                }
            )
        }

        binding?.sortAlphabetDescending?.setOnClickListener {

            exchangeRateViewModel?.getSortCurrencyAlphabetDescending?.observe(
                viewLifecycleOwner, Observer {
                    exchangeRateAdapter?.setList(it)
                    exchangeRateAdapter?.notifyDataSetChanged()
                }
            )

        }

        binding?.sortNumberAscending?.setOnClickListener {

            exchangeRateViewModel?.getSortCurrencyNumberAscending?.observe(
                viewLifecycleOwner, Observer {
                    exchangeRateAdapter?.setList(it)
                    exchangeRateAdapter?.notifyDataSetChanged()
                }
            )

        }

        binding?.sortNumberDescending?.setOnClickListener {

            exchangeRateViewModel?.getSortCurrencyNumberDescending?.observe(
                viewLifecycleOwner, Observer {
                    exchangeRateAdapter?.setList(it)
                    exchangeRateAdapter?.notifyDataSetChanged()
                }
            )

        }

        val array = arrayOf("USD", "RON", "GBP")

        val rootView = inflater.inflate(R.layout.fragment_exchange_rate, container, false)

        val adapter =  ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, array)
      //  spinner = rootView.findViewById<Spinner>(R.id.spinner)

        binding?.spinner?.adapter = adapter

      //  spinner = view?.findViewById<Spinner>(R.id.spinner)


        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter

/*        ArrayAdapter.createFromResource(
            activity?.applicationContext!!,
            R.array.currency_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner?.adapter = adapter
        }*/

        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                //  result?.text = array.get(p2)

                when(p2) {
                   // 0 -> result?.text = array.get(0)
                  //  1 -> result?.text = array.get(1)
                  //  2 -> result?.text = array.get(2)
                }
            }


            override fun onNothingSelected(p0: AdapterView<*>?) {
                // result?.text = array.get(0)
            }

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
            exchangeRateModel.exchange.toString(),
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
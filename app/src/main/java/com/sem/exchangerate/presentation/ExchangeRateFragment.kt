package com.sem.exchangerate.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.exchangerate.R
import com.sem.exchangerate.databinding.FragmentExchangeRateBinding
import com.sem.exchangerate.presentation.viewModel.ExchangeRateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer

class ExchangeRateFragment : Fragment() {

    private var binding: FragmentExchangeRateBinding? = null
    private var exchangeRateAdapter : ExchangeRateAdapter? = null
    private val exchangeRateViewModel : ExchangeRateViewModel? by viewModel()

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
        exchangeRateAdapter = ExchangeRateAdapter()

        binding?.exchangeRateRV?.adapter = exchangeRateAdapter
    }

    private fun loadExchangeRate(){

        exchangeRateViewModel?.loadExchange?.observe(viewLifecycleOwner, Observer {
            // setList наполняет адаптер данными
            exchangeRateAdapter?.setList(it)
            // notifyDataSetChanged обновляет адаптер
            exchangeRateAdapter?.notifyDataSetChanged()
        })

    }

}
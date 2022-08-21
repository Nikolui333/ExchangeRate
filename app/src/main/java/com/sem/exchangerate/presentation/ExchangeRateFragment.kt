package com.sem.exchangerate.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sem.exchangerate.R
import com.sem.exchangerate.databinding.FragmentExchangeRateBinding

class ExchangeRateFragment : Fragment() {

    private var binding: FragmentExchangeRateBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_exchange_rate, container, false)

        return binding?.root
    }


}
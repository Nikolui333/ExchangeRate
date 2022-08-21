package com.sem.exchangerate.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sem.exchangerate.R
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.databinding.ExchangeRateItemBinding

class ExchangeRateAdapter : RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateHolder>() {

    private val exchangeRate = ArrayList<ExchangeRateModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeRateHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ExchangeRateItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.exchange_rate_item, parent, false)
        return ExchangeRateHolder(binding)
    }

    override fun getItemCount(): Int {
        return exchangeRate.size
    }

    override fun onBindViewHolder(holder: ExchangeRateHolder, position: Int) {
        holder.bind(exchangeRate[position])

    }

    class ExchangeRateHolder(val binding: ExchangeRateItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exchangeRateModel: ExchangeRateModel){
            binding.name.text = exchangeRateModel.name
            binding.num.text = exchangeRateModel.exchange.toString()
        }

    }

}
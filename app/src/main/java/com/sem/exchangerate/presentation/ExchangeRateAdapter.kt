package com.sem.exchangerate.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageButton
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sem.exchangerate.R
import com.sem.exchangerate.data.models.ExchangeRateModel
import com.sem.exchangerate.databinding.ExchangeRateItemBinding
import android.view.View

class ExchangeRateAdapter(private val addToFavourite:(ExchangeRateModel)->Unit, private val removeFromFavourite:(ExchangeRateModel)->Unit,
                          private val loadMedicationsToCardFromFavourite:(Int, AppCompatImageButton, AppCompatImageButton)->Unit) : RecyclerView.Adapter<ExchangeRateAdapter.ExchangeRateHolder>() {

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
        holder.bind(exchangeRate[position], addToFavourite, removeFromFavourite, loadMedicationsToCardFromFavourite)

    }

    fun setList(exchangeRateList: List<ExchangeRateModel>) {
        exchangeRate.clear()
        exchangeRate.addAll(exchangeRateList)
    }

    class ExchangeRateHolder(val binding: ExchangeRateItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(exchangeRateModel: ExchangeRateModel, addToFavourite: (ExchangeRateModel) -> Unit,
                 removeFromFavourite: (ExchangeRateModel) -> Unit,
                 loadMedicineToCardFromFavourite: (Int, AppCompatImageButton, AppCompatImageButton) -> Unit){
            binding.name.text = exchangeRateModel.name
            binding.num.text = exchangeRateModel.exchange


        binding.addToFavourite.setOnClickListener(View.OnClickListener {

            addToFavourite(exchangeRateModel)

        })

        binding.removeFromFavourite.setOnClickListener(View.OnClickListener {

            removeFromFavourite(exchangeRateModel)

        })

        loadMedicineToCardFromFavourite(exchangeRateModel.id, binding.addToFavourite, binding.removeFromFavourite)

        }
    }

}
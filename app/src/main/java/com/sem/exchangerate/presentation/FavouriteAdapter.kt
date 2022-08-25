package com.sem.exchangerate.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.sem.exchangerate.R
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.databinding.FavouriteItemBinding
import com.squareup.picasso.Picasso

class FavouriteAdapter(private val deleteFromFavourite:(FavouriteModel)->Unit) : RecyclerView.Adapter<FavouriteAdapter.FavouriteHolder>() {

    private val currencyFromFavourite = ArrayList<FavouriteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FavouriteItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.favourite_item, parent, false)
        return FavouriteHolder(binding)
    }

    override fun getItemCount(): Int {
        return currencyFromFavourite.size
    }

    override fun onBindViewHolder(holder: FavouriteHolder, position: Int) {
        holder.bind(currencyFromFavourite[position], deleteFromFavourite)

    }

    fun setList(cardList: List<FavouriteModel>) {
        currencyFromFavourite.clear()
        currencyFromFavourite.addAll(cardList)

    }

    class FavouriteHolder(val binding: FavouriteItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            favouriteModel: FavouriteModel, deleteFromFavourite: (FavouriteModel) -> Unit
        ) {

            binding.name.text = favouriteModel.name
            binding.num.text = favouriteModel.exchange

            binding.removeFromFavourite.setOnClickListener(View.OnClickListener {
                deleteFromFavourite(favouriteModel)
            })

        }
    }

}
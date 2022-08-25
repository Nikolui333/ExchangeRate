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

class FavouriteAdapter(private val deleteFromCard:(FavouriteModel)->Unit) : RecyclerView.Adapter<FavouriteAdapter.FavouriteHolder>() {

    private val productsFromCard = ArrayList<FavouriteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: FavouriteItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.favourite_item, parent, false)
        return FavouriteHolder(binding)
    }

    override fun getItemCount(): Int {
        return productsFromCard.size
    }

    override fun onBindViewHolder(holder: FavouriteHolder, position: Int) {
        holder.bind(productsFromCard[position], deleteFromCard)

    }

    fun setList(cardList: List<FavouriteModel>) {
        productsFromCard.clear()
        productsFromCard.addAll(cardList)

    }

    class FavouriteHolder(val binding: FavouriteItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(
            favouriteModel: FavouriteModel, deleteFromCard: (FavouriteModel) -> Unit
        ) {

            binding.name.text = favouriteModel.name
            binding.num.text = favouriteModel.exchange

            binding.removeFromFavourite.setOnClickListener(View.OnClickListener {
                deleteFromCard(favouriteModel) // удаление из карточки, когда пользоваетль находится в корзине
            })

        }
    }

}
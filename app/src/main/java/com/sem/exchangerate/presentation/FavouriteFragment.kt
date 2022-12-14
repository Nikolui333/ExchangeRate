package com.sem.exchangerate.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.sem.exchangerate.R
import com.sem.exchangerate.data.models.FavouriteModel
import com.sem.exchangerate.databinding.FragmentFavouriteBinding
import com.sem.exchangerate.presentation.viewModel.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer

class FavouriteFragment : Fragment(){

    private var binding: FragmentFavouriteBinding? = null
    private var favouriteAdapter: FavouriteAdapter? = null
    private val favouriteViewModel: FavouriteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favourite, container, false)
        initRecyclerCard()
        loadCurrencyFromFavourite()

        return binding?.root
    }

    // инициализация
    private fun initRecyclerCard() {

        binding?.favouriteRateRV?.layoutManager =
            LinearLayoutManager(context)
        favouriteAdapter =
            FavouriteAdapter ({ favouriteModel: FavouriteModel ->
                deleteFromFavourite(
                    favouriteModel
                )
            })
        binding?.favouriteRateRV?.adapter = favouriteAdapter
    }

    private fun loadCurrencyFromFavourite() {

        favouriteViewModel.loadCurrencyFromFavourite.observe(viewLifecycleOwner, Observer {
            favouriteAdapter?.setList(it)
            favouriteAdapter?.notifyDataSetChanged()

        })
    }

    private fun deleteFromFavourite(favouriteModel: FavouriteModel){

        favouriteViewModel.deleteCurrencyFromFavourite(favouriteModel.id)
    }

}
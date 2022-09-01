package com.sem.exchangerate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sem.exchangerate.R
import com.sem.exchangerate.databinding.ActivityMainBinding
import com.sem.exchangerate.presentation.viewModel.ExchangeRateViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    private val exchangeRateViewModel : ExchangeRateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        exchangeRateViewModel.migration(this, "USD")

        setSupportActionBar(binding?.topMainMenu)

        supportFragmentManager.beginTransaction().replace(R.id.mainContent, ExchangeRateFragment()).commit()

        binding?.bottomMainMenu?.setOnItemSelectedListener { item ->

            when(item.itemId) {
                R.id.rateBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, ExchangeRateFragment()).commit()
                R.id.favoriteBottomMainMenu -> supportFragmentManager.beginTransaction().replace(R.id.mainContent, FavouriteFragment()).commit()
            }

            return@setOnItemSelectedListener true

        }
        binding?.bottomMainMenu?.selectedItemId = R.id.rateBottomMainMenu
    }
}
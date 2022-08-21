package com.sem.exchangerate.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sem.exchangerate.R
import com.sem.exchangerate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // запуск фрагмента Home (в данном случае он является фрагментом по умолчанию)
        supportFragmentManager.beginTransaction().replace(R.id.mainContent, ExchangeRateFragment()).commit()

        setSupportActionBar(binding?.topMainMenu)

        // обработчик нажатий по вкладнкам
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
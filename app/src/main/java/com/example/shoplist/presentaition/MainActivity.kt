package com.example.shoplist.presentaition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.shoplist.R

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this) [MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MyTag", it.toString())
            if (count==0) {
                count++
                val item = it[0]
                viewModel.changeEnableState(item)
            }

        }

    }
}
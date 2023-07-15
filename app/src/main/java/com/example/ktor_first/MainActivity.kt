package com.example.ktor_first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ktor_first.databinding.ActivityMainBinding
import com.example.ktor_first.network.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val apiService=ApiService.getRequest()
    private lateinit var quoteAdapter: QuoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            val quoteList=apiService.getQuotes()
            quoteAdapter= QuoteAdapter(quoteList)
            withContext(Dispatchers.Main){
                binding.recyclerQuotes.layoutManager=LinearLayoutManager(this@MainActivity)
                binding.recyclerQuotes.adapter=quoteAdapter
                quoteAdapter.notifyDataSetChanged()
            }
        }
    }
}
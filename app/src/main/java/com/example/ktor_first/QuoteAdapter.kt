package com.example.ktor_first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ktor_first.databinding.QuoteLayoutBinding
import com.example.ktor_first.model.Quote

class QuoteAdapter(private val quotes:List<Quote>):RecyclerView.Adapter<QuoteAdapter.ViewHolder>() {

    // the view holder holds a reference to the generated binding class for the item layout
    class ViewHolder(val binding: QuoteLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //create an instance of quote_layout binding class and passes the custom view as a parameter
        val view=QuoteLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote=quotes[position]
        // use the instance of the binding class to access views in the current view holder
        holder.binding.quote.text=quote.quote
        holder.binding.author.text=quote.author
        holder.binding.category.text=quote.category
    }
}
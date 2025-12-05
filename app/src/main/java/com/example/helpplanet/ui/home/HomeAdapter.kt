package com.example.helpplanet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helpplanet.databinding.ItemDesafioBinding

class HomeAdapter(
    private val lista: List<String>
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDesafioBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDesafioBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]
        holder.binding.txtDesafio.text = item
    }

    override fun getItemCount() = lista.size
}

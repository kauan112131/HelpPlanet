package com.example.helpplanet.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helpplanet.data.model.Desafio
import com.example.helpplanet.databinding.ItemDesafioBinding

class DesafioAdapter(
    private val lista: List<Desafio>,
    private val onClick: (Desafio) -> Unit
) : RecyclerView.Adapter<DesafioAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDesafioBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Desafio) {
            binding.txtTitulo.text = item.title
            binding.txtDescricao.text = item.body

            binding.root.setOnClickListener {
                onClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDesafioBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(lista[position])
    }

    override fun getItemCount() = lista.size
}

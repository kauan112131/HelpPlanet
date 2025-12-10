package com.example.helpplanet.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.helpplanet.data.model.Desafio
import com.example.helpplanet.databinding.ItemDesafioBinding

class DesafioAdapter(
    private val lista: List<Desafio>,
    private val onDetalhesClick: (Desafio) -> Unit
) : RecyclerView.Adapter<DesafioAdapter.ViewHolder>() {

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

    override fun getItemCount() = lista.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = lista[position]

        holder.binding.txtTitulo.text = item.title
        holder.binding.txtDescricao.text = item.body

        holder.binding.btnDetalhes.setOnClickListener {
            onDetalhesClick(item)
        }
    }
}

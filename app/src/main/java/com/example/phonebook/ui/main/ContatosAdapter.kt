package com.example.phonebook.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.phonebook.R
import com.example.phonebook.models.Contato

class ContatosAdapter() : RecyclerView.Adapter<ContatosAdapter.ContatosViewHolder>() {

    private val contatos = arrayListOf<Contato>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContatosViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)
        return ContatosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContatosViewHolder, position: Int) {
        val contato = contatos[position]
        holder.tvNomeContato.text = contato.nome
        holder.tvTelefoneContato.text = contato.telefone
    }

    override fun getItemCount() = contatos.size

    fun setListContatos(list: List<Contato>) {
        contatos.addAll(list)
        notifyDataSetChanged()
    }

    inner class ContatosViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvNomeContato: TextView = itemView.findViewById(R.id.tvNome)
        var tvTelefoneContato: TextView = itemView.findViewById(R.id.tvTelefone)
    }
}
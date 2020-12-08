package com.example.phonebook.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contatos")
data class Contato(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var nome: String,

    var telefone: String
)
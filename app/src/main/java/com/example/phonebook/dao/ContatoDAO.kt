package com.example.phonebook.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.phonebook.models.Contato

@Dao
interface ContatoDAO {
    @Insert
    suspend fun addContato(contato: Contato)

    @Query("SELECT * FROM contatos")
    suspend fun getAllContatos(): List<Contato>
}
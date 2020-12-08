package com.example.phonebook.services

import com.example.phonebook.dao.ContatoDAO
import com.example.phonebook.models.Contato

interface Repository {
    suspend fun addContatoTask(contato: Contato)

    suspend fun getAllContatosTask(): List<Contato>
}

class RepositoryImplementation(val contatoDAO: ContatoDAO) : Repository {
    override suspend fun addContatoTask(contato: Contato) {
        contatoDAO.addContato(contato)
    }

    override suspend fun getAllContatosTask(): List<Contato> {
        return contatoDAO.getAllContatos()
    }
}
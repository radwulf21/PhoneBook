package com.example.phonebook.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebook.models.Contato
import com.example.phonebook.services.Repository
import kotlinx.coroutines.launch

class MainViewModel(val repository: Repository) : ViewModel() {
    val contatos = MutableLiveData<List<Contato>>()

    fun getAllContatosDB() {
        viewModelScope.launch {
            contatos.value = repository.getAllContatosTask()
        }
    }
}
package com.example.phonebook.ui.addcontact

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phonebook.models.Contato
import com.example.phonebook.services.Repository
import kotlinx.coroutines.launch

class AddContactViewModel(val repository: Repository) : ViewModel() {
    fun addContatoDB(contato: Contato) {
        viewModelScope.launch {
            repository.addContatoTask(contato)
        }
    }
}
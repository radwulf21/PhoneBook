package com.example.phonebook.ui.addcontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.phonebook.R
import com.example.phonebook.database.AppDataBase
import com.example.phonebook.models.Contato
import com.example.phonebook.services.Repository
import com.example.phonebook.services.RepositoryImplementation
import com.example.phonebook.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_addcontacts.*

class AddContactActivity : AppCompatActivity() {
    private lateinit var db: AppDataBase
    private lateinit var repository : Repository

    private val viewModel by viewModels<AddContactViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return AddContactViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addcontacts)

        initDB()
        repository = RepositoryImplementation(db.contatoDAO())

        btnSalvar.setOnClickListener {
            viewModel.addContatoDB(Contato(nome = etNome.text.toString(), telefone = etTelefone.text.toString()))
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun initDB() {
        db = AppDataBase.invoke(this)
    }
}
package com.example.phonebook.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phonebook.R
import com.example.phonebook.database.AppDataBase
import com.example.phonebook.services.Repository
import com.example.phonebook.services.RepositoryImplementation
import com.example.phonebook.ui.addcontact.AddContactActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adapter = ContatosAdapter()
    private lateinit var db: AppDataBase
    private lateinit var repository : Repository

    private val viewModel by viewModels<MainViewModel> {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return MainViewModel(repository) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvContatos.adapter = adapter
        rvContatos.layoutManager = LinearLayoutManager(this)


        fbAddContato.setOnClickListener {
            startActivity(Intent(this, AddContactActivity::class.java))
        }

        initDB()
        repository = RepositoryImplementation(db.contatoDAO())
        viewModel.getAllContatosDB()

        viewModel.contatos.observe(this) {
            adapter.setListContatos(it)
        }
    }

    fun initDB() {
        db = AppDataBase.invoke(this)
    }
}
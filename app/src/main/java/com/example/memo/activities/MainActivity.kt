package com.example.memo.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.memo.R
import com.example.memo.databinding.ActivityMainBinding
import com.example.memo.db.NoteDatabase
import com.example.memo.repository.NoteRepository
import com.example.memo.viewModel.NoteActivityViewModel
import com.example.memo.viewModel.NoteActivityViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteActivityViewModel: NoteActivityViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityMainBinding.inflate(layoutInflater)

        try {
            setContentView(binding.root)
            val noteRepository = NoteRepository(NoteDatabase(this))
            val noteActivityViewModelFactory = NoteActivityViewModelFactory(noteRepository)
            noteActivityViewModel = ViewModelProvider(this,
            noteActivityViewModelFactory)[NoteActivityViewModel::class.java]
        }catch (e: Exception) {
            Log.d("TAG",e.toString())
        }
    }
}
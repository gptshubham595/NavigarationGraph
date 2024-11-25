package com.oops.navigarationgraph.presentation.feature.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.oops.navigarationgraph.databinding.ActivityMainBinding
import com.oops.navigarationgraph.presentation.feature.viewmodels.MainViewModel
import com.oops.navigarationgraph.presentation.feature.views.fragments.TodoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFragments()
    }

    private fun initFragments() {
//        val todoFragment = TodoFragment()
//        val transactionManager = supportFragmentManager.beginTransaction()
//        transactionManager.add(binding.fragmentContainer.id, todoFragment)
//        transactionManager.addToBackStack("TODO_FRAGMENT")
//        transactionManager.commit()
    }
}
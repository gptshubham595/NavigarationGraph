package com.oops.navigarationgraph.presentation.feature.views

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.oops.navigarationgraph.databinding.ActivityMainBinding
import com.oops.navigarationgraph.presentation.feature.viewmodels.MainViewModel
import com.oops.navigarationgraph.presentation.feature.views.fragments.Todo1Fragment
import com.oops.navigarationgraph.presentation.feature.views.fragments.Todo2Fragment
import com.oops.navigarationgraph.presentation.feature.views.fragments.Todo3Fragment
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
        val todo1Fragment = Todo1Fragment()
        val todo2Fragment = Todo2Fragment()
        val todo3Fragment = Todo3Fragment()
        val transactionManager = supportFragmentManager.beginTransaction()
        transactionManager.add(binding.fragmentContainer.id, todo1Fragment)
        transactionManager.add(binding.fragmentContainer.id, todo2Fragment)
        transactionManager.add(binding.fragmentContainer.id, todo3Fragment)
        transactionManager.addToBackStack("TODO_FRAGMENT")
        transactionManager.commit()
    }
}
package com.oops.navigarationgraph.presentation.feature.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.oops.navigarationgraph.databinding.FragmentTodo2Binding
import com.oops.navigarationgraph.presentation.feature.viewmodels.MainViewModel
import com.oops.navigarationgraph.presentation.feature.viewmodels.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Todo2Fragment : Fragment() {
    private val viewModel: MainViewModel by activityViewModels()
    private val todoViewModel: TodoViewModel by viewModels()

    private lateinit var binding: FragmentTodo2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentTodo2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}
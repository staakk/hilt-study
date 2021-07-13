package com.example.hiltstudy.assistedinjection.viewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.assistedinjection.databinding.ExampleFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class AssistedInjectFragment : Fragment() {

    @Inject
    lateinit var assistedInjectViewModelFactory: AssistedInjectViewModelFactory

    private lateinit var binding: ExampleFragmentBinding

    private val viewModel: AssistedInjectViewModel by viewModels {
        AssistedInjectViewModel.provideFactory(
            assistedFactory = assistedInjectViewModelFactory,
            arg = requireArguments().getString("arg", "")
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExampleFragmentBinding.inflate(inflater, container, false)
        binding.text.text = viewModel.arg
        return binding.root
    }
}
package com.example.hiltstudy.assistedinjection.regular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.assistedinjection.databinding.ExampleFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegularFragment : Fragment() {

    private val viewModel: RegularViewModel by viewModels()

    private lateinit var binding: ExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExampleFragmentBinding.inflate(layoutInflater, container, false)
        binding.text.text = viewModel.arg
        return binding.root
    }
}
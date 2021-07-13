package com.example.hiltstudy.assistedinjection.serviceconfig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.assistedinjection.databinding.ExampleFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ServiceConfigFragment : Fragment() {

    @Inject
    lateinit var serviceFactory: MyServiceFactory

    private lateinit var binding: ExampleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ExampleFragmentBinding.inflate(inflater, container, false)
        val myService = serviceFactory.create(requireArguments().getString("arg", ""))
        binding.text.text = myService.arg
        return binding.root
    }
}
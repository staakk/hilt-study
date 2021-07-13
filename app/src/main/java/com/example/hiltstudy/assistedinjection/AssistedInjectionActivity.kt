package com.example.hiltstudy.assistedinjection

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import com.example.assistedinjection.R
import com.example.assistedinjection.databinding.ActivityMainBinding
import com.example.assistedinjection.databinding.AssistedInjectionActivityBinding
import com.example.hiltstudy.assistedinjection.regular.RegularFragment
import com.example.hiltstudy.assistedinjection.serviceconfig.ServiceConfigFragment
import com.example.hiltstudy.assistedinjection.viewmodel.AssistedInjectFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AssistedInjectionActivity : AppCompatActivity() {

    private lateinit var binding: AssistedInjectionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AssistedInjectionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.goToExample1.setOnClickListener {
            supportFragmentManager.commit {
                replace(
                    R.id.fragment_container,
                    ServiceConfigFragment::class.java,
                    Bundle().apply {
                        putString("arg", "Hello from ServiceConfigFragment!")
                    }
                )
            }
        }

        binding.goToExample2.setOnClickListener {
            supportFragmentManager.commit {
                replace(
                    R.id.fragment_container,
                    AssistedInjectFragment::class.java,
                    Bundle().apply {
                        putString("arg", "Hello from AssistedInjectFragment!")
                    }
                )
            }
        }

        binding.goToExample3.setOnClickListener {
            supportFragmentManager.commit {
                replace(
                    R.id.fragment_container,
                    RegularFragment::class.java,
                    Bundle().apply {
                        putString("arg", "Hello from RegularFragment!")
                    }
                )
            }
        }
    }
}
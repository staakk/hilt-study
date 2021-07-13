package com.example.hiltstudy.scopes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.assistedinjection.databinding.ScopesActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ScopesActivity : AppCompatActivity() {

    private lateinit var binding: ScopesActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ScopesActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState ?: run {
            supportFragmentManager.commit {
                add(binding.fragmentContainer.id, ScopesFragment())
            }
        }
    }

    fun recreateFragment() {
        supportFragmentManager.commit {
            replace(binding.fragmentContainer.id, ScopesFragment())
        }
    }
}
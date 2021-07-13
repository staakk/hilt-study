package com.example.hiltstudy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assistedinjection.databinding.ActivityMainBinding
import com.example.hiltstudy.assistedinjection.AssistedInjectionActivity
import com.example.hiltstudy.scopes.ScopesActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.assistedInjection.setOnClickListener {
            startActivity(Intent(this, AssistedInjectionActivity::class.java))
        }

        binding.scopes.setOnClickListener {
            startActivity(Intent(this, ScopesActivity::class.java))
        }
    }
}
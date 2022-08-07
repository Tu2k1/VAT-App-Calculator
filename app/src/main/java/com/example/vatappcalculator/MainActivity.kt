package com.example.vatappcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vatappcalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root // reference to layout file
        setContentView(view) // link the layout to the app
    }
}
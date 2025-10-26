package com.example.mobilkaedu3

import android.os.Bundle
import android.content.Intent
import androidx.activity.ComponentActivity
import com.example.mobilkaedu3.databinding.ActivitySecondaryBinding

class SecondaryActivity : ComponentActivity() {
    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupButtonListeners()
    }

    private fun setupButtonListeners() {
        binding.buttonOne.setOnClickListener { returnResult(1) }
        binding.buttonTwo.setOnClickListener { returnResult(2) }
        binding.buttonThree.setOnClickListener { returnResult(3) }
    }

    private fun returnResult(imageId: Int) {
        val resultIntent = Intent().apply {
            putExtra("selected_image_id", imageId)
        }

        setResult(RESULT_OK, resultIntent)
        finish()
    }
}

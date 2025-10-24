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

        changeImageView()
    }

    private fun changeImageView() {
        binding.buttonOne.setOnClickListener {
            returnResult(1)
        }

        binding.buttonTwo.setOnClickListener {
            returnResult(2)
        }

        binding.buttonThree.setOnClickListener {
            returnResult(3)
        }
    }

    private fun returnResult(imageId: Int) {
        // Создаем Bundle и группируем в нем данные
        val resultBundle = Bundle().apply {
            putInt("selected_image_id", imageId)
        }

        // Создаем Intent и передаем Bundle с помощью putExtra
        val resultIntent = Intent().apply {
            putExtra("result_bundle", resultBundle)  // Bundle как объект
        }

        setResult(RESULT_OK, resultIntent)
        finish()
    }
}
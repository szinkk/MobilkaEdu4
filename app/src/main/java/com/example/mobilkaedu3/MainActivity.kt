package com.example.mobilkaedu3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.mobilkaedu3.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedImageId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        savedInstanceState?.let {
            selectedImageId = it.getInt("SELECTED_IMAGE_ID", 1)
        }

        requestSecondary()
        updateImage()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SELECTED_IMAGE_ID", selectedImageId)
    }

    private fun requestSecondary() {
        binding.buttonNextActivity.setOnClickListener {
            startActivityForResult(
                Intent(this, SecondaryActivity::class.java), 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        selectedImageId = data?.getIntExtra("selected_image_id", 1) ?: 1
        updateImage()
    }

    private fun updateImage() {
        val imageResource = when (selectedImageId) {
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            else -> R.drawable.one
        }
        binding.imageViewNumbers.setImageResource(imageResource)
    }
}

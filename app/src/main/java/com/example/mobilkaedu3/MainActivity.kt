package com.example.mobilkaedu3

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.mobilkaedu3.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private var selectedImageId = 1

    companion object {
        private const val SELECT_IMAGE_REQUEST = 1
        private const val RESULT_BUNDLE_KEY = "result_bundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Восстанавливаем состояние из Bundle (при повороте экрана)
        savedInstanceState?.let { bundle ->
            selectedImageId = bundle.getInt("SELECTED_IMAGE_ID", 1)
        }

        setupUI()
    }

    // Сохраняем состояние в Bundle
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("SELECTED_IMAGE_ID", selectedImageId)
    }

    private fun setupUI() {
        updateImage()

        binding.buttonNextActivity.setOnClickListener {
            val intent = Intent(this, SecondaryActivity::class.java)
            startActivityForResult(intent, SELECT_IMAGE_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == SELECT_IMAGE_REQUEST && resultCode == RESULT_OK) {
            // Получаем Bundle из Intent с помощью getBundleExtra
            val resultBundle = data?.getBundleExtra(RESULT_BUNDLE_KEY)
            val imageId = resultBundle?.getInt("selected_image_id", 1) ?: 1
            selectedImageId = imageId
            updateImage()
        }
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
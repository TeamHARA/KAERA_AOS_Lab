package com.android.focusedittext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.android.focusedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.textInputLayout.editText?.setOnFocusChangeListener { _, hasFocus ->
//            if (hasFocus) {
//                binding.textInputLayout.boxStrokeColor = ContextCompat.getColor(this, R.color.red)
//            } else {
//                binding.textInputLayout.boxStrokeColor = ContextCompat.getColor(this, R.color.black)
//            }
//        }
//
//        binding.textInputLayout2.editText?.setOnFocusChangeListener { _, hasFocus ->
//            if (hasFocus) {
//                binding.textInputLayout2.boxStrokeColor = ContextCompat.getColor(this, R.color.red)
//            } else {
//                binding.textInputLayout2.boxStrokeColor = ContextCompat.getColor(this, R.color.black)
//            }
//        }

    }
}
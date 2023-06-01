package com.android.focusedittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.android.focusedittext.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    binding.textInputLayout.error = " "
                } else {
                    s.toString().toIntOrNull()?.let {
                        if (s != null) {
                            if (s.length > 4) {
                                binding.textInputLayout.error = " "
                            } else {
                                binding.textInputLayout.error = null
                            }
                        }
                    } ?: run {
                        binding.textInputLayout.error = " "
                    }
                }
            }
        })

        binding.editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {
                    binding.textInputLayout2.error = "공백은 허용하지 않습니다."
                } else {
                    s.toString().toIntOrNull()?.let {
                        if (s != null) {
                            if (s.length > 4) {
                                binding.textInputLayout2.error = "4글자가 초과되었습니다."
                            } else {
                                binding.textInputLayout2.error = null
                            }
                        }
                    } ?: run {
                        binding.textInputLayout2.error = "숫자를 입력하세요."
                    }
                }
            }
        })

    }

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

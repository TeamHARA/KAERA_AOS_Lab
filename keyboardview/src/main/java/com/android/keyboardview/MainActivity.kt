package com.android.keyboardview

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import com.android.keyboardview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.root.viewTreeObserver.addOnGlobalLayoutListener {
            val r = Rect()
            binding.root.getWindowVisibleDisplayFrame(r)
            val screenHeight: Int = binding.root.rootView.height

            // 키보드가 열렸는지 여부 확인
            val keypadHeight = screenHeight - r.bottom
            val isKeyboardOpen = keypadHeight > screenHeight * 0.15

            if (isKeyboardOpen) {
                // 키보드가 열렸을 때 처리할 작업
                binding.clTarget.visibility = View.VISIBLE
            } else {
                // 키보드가 닫혔을 때 처리할 작업
                binding.clTarget.visibility = View.GONE
            }
        }
    }

}
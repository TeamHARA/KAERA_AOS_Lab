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
        // 현재 매니페스트파일에서 adjustresize 속성을 통해서 사용하고 있음
        // 하지만 현재 이속성은 지원중단이므로 나중에는 해당 코드를 대체해야함..
        // 우선 현재는 이걸로 만족
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
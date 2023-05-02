package com.android.expandableview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.android.expandableview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var expand = false

        binding.ivArrow.setOnClickListener {
            expand = toggleLayout(!expand, binding.ivArrow, binding.clContent)
        }
    }

    fun toggleLayout(isExpanded: Boolean, view: View, layoutExpand: ConstraintLayout): Boolean {
        // 토글 레이아웃을 위한 애니메이션
        ExpandAnimation.toggleArrow(view, isExpanded)
        if (isExpanded) {
            ExpandAnimation.expand(layoutExpand)
        } else {
            ExpandAnimation.collapse(layoutExpand)
        }
        return isExpanded
    }
}
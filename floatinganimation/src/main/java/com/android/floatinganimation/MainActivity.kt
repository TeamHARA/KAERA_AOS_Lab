package com.android.floatinganimation

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.animation.*
import androidx.appcompat.app.AppCompatActivity
import com.android.floatinganimation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    @SuppressLint("ObjectAnimatorBinding")

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val animator = ValueAnimator.ofInt(200, 300).apply { // 지혼자 움찔거리는 애니메이션
            duration = 1000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.REVERSE
            startDelay = 1000
            addUpdateListener { animation ->
                val layoutParams = binding.ivOre.layoutParams.apply {
                    height = animation.animatedValue as Int
                }
                layoutParams.height = animation.animatedValue as Int
                binding.ivOre.layoutParams = layoutParams
            }
        }
        animator.start()

//        binding.apply { // translateAnimation
//            tvGem.startAnimation(floatingAnimationWithTranslateAnimation(0, 1000,-50F))
//            tvStone.startAnimation(floatingAnimationWithTranslateAnimation(500, 1000,-50F))
//            clGem.startAnimation(floatingAnimationWithTranslateAnimation(1500, 1000,-50F))
//            clStone.startAnimation(floatingAnimationWithTranslateAnimation(2000, 1000,-50F))
//        }

        binding.apply { // ValueAnimator
            floatingAnimationWithValueAnimator(0, 1000,tvGem,-50F).start()
            floatingAnimationWithValueAnimator(500, 1000,tvStone,-50F).start()
            floatingAnimationWithValueAnimator(1500, 1000,clGem,-50F).start()
            floatingAnimationWithValueAnimator(2000, 1000,clStone,-50F).start()
        }



    }

    fun floatingAnimationWithTranslateAnimation(start: Long, dur:Long, movement: Float): TranslateAnimation {
        //start offSet은 시작 시점
        //movement는 둥둥 떠나니기 위한 Y축 이동 거리
        return TranslateAnimation(0F, 0F, 0F, movement).apply {
            duration = dur
            repeatMode = Animation.REVERSE
            //interpolator = AccelerateInterpolator()
            //interpolator = LinearInterpolator()
            //interpolator = DecelerateInterpolator()
            interpolator = AccelerateDecelerateInterpolator()
            startOffset = start
            repeatCount = Animation.INFINITE
        }
         // 현재 문제는 startOffset자체가 애니메이션 시작을 딜레이하는거라 REVERSE하게 되면 위에서 한번 아래서 한번
        // 멈추는 문제가 있음
    }

    fun floatingAnimationWithValueAnimator(start: Long, dur:Long, view : View, movement: Float) : ValueAnimator{
        return ValueAnimator.ofFloat(0f,1f).apply {
            duration = dur
            repeatMode = ValueAnimator.REVERSE
            repeatCount = ValueAnimator.INFINITE
            //interpolator = AccelerateInterpolator()
            //interpolator = LinearInterpolator()
            //interpolator = DecelerateInterpolator()
            interpolator = AccelerateDecelerateInterpolator()
            startDelay = start
            addUpdateListener {
                view.translationY = animatedValue as Float * 20f
            }
        }
    }

}
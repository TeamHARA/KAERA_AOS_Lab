package com.example.floatinganimation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CustomFloatingView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : this(context, attrs)
    private var mPaint: Paint? = null
    private val mRadius = 50F
    private var mX = 0F
    private var mY = 0F

    init {
        init()
    }

    private fun init() {
        mPaint = Paint()
        mPaint!!.setColor(Color.RED)
        mPaint!!.setStyle(Paint.Style.FILL)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint?.let { canvas.drawCircle(mX, mY, mRadius, it) }
    }

    fun setCoordinates(x: Float, y: Float) {
        mX = x
        mY = y
        invalidate()
    }
}

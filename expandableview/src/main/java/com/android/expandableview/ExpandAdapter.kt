package com.android.expandableview

import android.animation.LayoutTransition
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.expandableview.databinding.ItemExpandBinding

class ExpandAdapter : ListAdapter<SampleData, ExpandAdapter.ItemViewHolder>(GlobalDiffCallBack()) {

    private lateinit var inflater: LayoutInflater

    class ItemViewHolder(val binding: ItemExpandBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        if (!::inflater.isInitialized) {
            inflater = LayoutInflater.from(parent.context)
        }
        return ItemViewHolder(ItemExpandBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val curItem = getItem(position)
        with(holder) {
            //this.binding.root.layoutTransition.enableTransitionType(LayoutTransition.DISAPPEARING)
            // android:animationLayoutChanges 속성 사용시 애니메이션 종류 변경
            binding.ivArrow.setOnClickListener {
                ExpandAnimation.toggleArrow(binding.ivArrow, !curItem.expand)
                if (!curItem.expand) {
                    ExpandAnimation.expand(binding.clContent)
//                    binding.clContent.requestLayout()
//                    TransitionManager.beginDelayedTransition(binding.clRoot)
//                    binding.clContent.visibility = View.VISIBLE
                    // 이렇게 하려면  android:animateLayoutChanges="true" 속성적용
                } else {
                    ExpandAnimation.collapse(binding.clContent)
//                    TransitionManager.beginDelayedTransition(binding.clRoot)
//                    binding.clContent.visibility = View.GONE
                }
                curItem.expand = !curItem.expand
            }
        }
    }


}
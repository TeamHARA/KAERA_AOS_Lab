package com.android.expandableview

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
            binding.ivArrow.setOnClickListener {
                ExpandAnimation.toggleArrow(binding.ivArrow, !curItem.expand)
                if (!curItem.expand) {
                    ExpandAnimation.expand(binding.clContent)
                    //binding.clContent.visibility = View.VISIBLE
                    // 이렇게 하려면  android:animateLayoutChanges="true" 속성적용
                } else {
                    ExpandAnimation.collapse(binding.clContent)
                    //binding.clContent.visibility = View.GONE
                }
                curItem.expand = !curItem.expand
            }
        }
    }

}
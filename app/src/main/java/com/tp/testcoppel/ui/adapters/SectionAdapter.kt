package com.tp.testcoppel.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tp.testcoppel.core.BaseViewHolder
import com.tp.testcoppel.data.local.SectionLocal
import com.tp.testcoppel.databinding.SectionItemBinding
import com.tp.testcoppel.ui.utils.loadImage2

class SectionAdapter(
    private val sectionsList: List<SectionLocal>,
    private val itemclick: OnListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnListener {
        fun onClick(section: SectionLocal)
    }

    private inner class SectionViewHolder(val binding: SectionItemBinding, val context: Context) :
        BaseViewHolder<SectionLocal>(binding.root) {
        override fun bind(item: SectionLocal) {
            binding.tvTittle.text = item.name
            binding.iv.loadImage2(item.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding =
            SectionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val holder = SectionViewHolder(itemBinding, parent.context)

        itemBinding.tvTittle.setOnClickListener {
            val position = holder.adapterPosition.takeIf { it != DiffUtil.DiffResult.NO_POSITION }
                ?: return@setOnClickListener

            itemclick.onClick(sectionsList[position])
        }
        return holder

    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is SectionViewHolder -> holder.bind(sectionsList[position])
        }
    }

    override fun getItemCount() = sectionsList.size

}
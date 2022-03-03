package com.tp.testcoppel.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tp.testcoppel.data.local.CharacterLocal
import com.tp.testcoppel.databinding.ItemCharactersBinding

class ItemsCharactersAdapter(private val itemClickListener : OnClikListener ):
    ListAdapter<CharacterLocal, ItemsCharactersAdapter.ViewHolder>(ItemCharacterCallback()) {


    class ViewHolder private constructor(val binding: ItemCharactersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CharacterLocal) {
            binding.character = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemCharactersBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.binding.character = item
        holder.itemView.setOnClickListener {
            itemClickListener.onCharacterClick(item)
        }
    }

    interface OnClikListener{
        fun onCharacterClick(characterLocal: CharacterLocal)
    }

}

class ItemCharacterCallback : DiffUtil.ItemCallback<CharacterLocal>() {
    override fun areItemsTheSame(oldItem: CharacterLocal, newItem: CharacterLocal): Boolean {
        return newItem == oldItem
    }

    override fun areContentsTheSame(oldItem: CharacterLocal, newItem: CharacterLocal): Boolean {
        return newItem.id == oldItem.id
    }

}
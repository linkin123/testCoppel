package com.tp.testcoppel.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tp.testcoppel.core.BaseConcatHolder
import com.tp.testcoppel.databinding.ComicsRowBinding
import com.tp.testcoppel.databinding.EventsRowBinding
import com.tp.testcoppel.databinding.SeriesRowBinding
import com.tp.testcoppel.databinding.StoriesRowBinding

enum class typeAdapter{ COMICS, EVENTS, SERIES, STORIES }

class GenericAdapter(private val sectionAdapter: SectionAdapter, private val type : typeAdapter) : RecyclerView.Adapter<BaseConcatHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseConcatHolder<*> {

        return when(type){
            typeAdapter.COMICS ->{
                val itemBinding =
                    ComicsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ConcatComicsViewHolder(itemBinding)
            }
            typeAdapter.EVENTS -> {
                val itemBinding =
                    EventsRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ConcatEventsViewHolder(itemBinding)
            }
            typeAdapter.SERIES -> {
                val itemBinding =
                    SeriesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ConcatSeriesViewHolder(itemBinding)
            }
            typeAdapter.STORIES -> {
                val itemBinding =
                    StoriesRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                ConcatStoriesViewHolder(itemBinding)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseConcatHolder<*>, position: Int) {
        when (holder) {
            is ConcatComicsViewHolder -> holder.bind(sectionAdapter)
            is ConcatEventsViewHolder -> holder.bind(sectionAdapter)
            is ConcatSeriesViewHolder -> holder.bind(sectionAdapter)
            is ConcatStoriesViewHolder -> holder.bind(sectionAdapter)
        }
    }

    override fun getItemCount() = 1

    private inner class ConcatComicsViewHolder(val binding : ComicsRowBinding) : BaseConcatHolder<SectionAdapter>(binding.root){
        override fun bind(adapter: SectionAdapter) {
            binding.rvSection.adapter = adapter
        }

    }

    private inner class ConcatEventsViewHolder(val binding: EventsRowBinding) :
        BaseConcatHolder<SectionAdapter>(binding.root) {
        override fun bind(adapter: SectionAdapter) {
            binding.rvSection.adapter = adapter
        }
    }

    private inner class ConcatSeriesViewHolder(val binding: SeriesRowBinding) :
        BaseConcatHolder<SectionAdapter>(binding.root) {
        override fun bind(adapter: SectionAdapter) {
            binding.rvSection.adapter = adapter
        }
    }

    private inner class ConcatStoriesViewHolder(val binding: StoriesRowBinding) :
        BaseConcatHolder<SectionAdapter>(binding.root) {
        override fun bind(adapter: SectionAdapter) {
            binding.rvSection.adapter = adapter
        }
    }

}
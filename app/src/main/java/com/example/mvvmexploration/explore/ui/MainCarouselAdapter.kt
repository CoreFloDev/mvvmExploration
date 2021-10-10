package com.example.mvvmexploration.explore.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexploration.R
import com.example.mvvmexploration.databinding.MainCarouselItemBinding

class MainCarouselAdapter : RecyclerView.Adapter<MainCarouselAdapter.MainCarouselViewHolder>() {

    private val list: List<Item> = listOf(
        Item(R.color.teal_200, "example title"),
        Item(R.color.purple_500, "other title"),
        Item(R.color.purple_200, "last item")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MainCarouselViewHolder(
        MainCarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: MainCarouselViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    class MainCarouselViewHolder(private val binding: MainCarouselItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.image.setBackgroundColor(ContextCompat.getColor(binding.root.context, item.color))
            binding.title.text = item.title
        }
    }
}

data class Item(
    @ColorRes val color: Int,
    val title: String
)

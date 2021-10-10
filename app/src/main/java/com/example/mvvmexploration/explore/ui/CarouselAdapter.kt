package com.example.mvvmexploration.explore.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmexploration.databinding.CarouselItemBinding
import com.example.mvvmexploration.explore.usecase.UiCarouselItem

class CarouselAdapter: RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    private var list: List<UiCarouselItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CarouselViewHolder(CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun update(list: List<UiCarouselItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    class CarouselViewHolder(private val binding: CarouselItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(uiCarouselItem: UiCarouselItem) {
            binding.name.text = uiCarouselItem.name
            binding.title.text = uiCarouselItem.title
        }
    }

}

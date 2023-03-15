package com.example.internetapidata

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.internetapidata.databinding.ItemCardBinding
import com.example.internetapidata.network.MarsItem

class MarsAdapter() : ListAdapter<MarsItem, MarsAdapter.MarsViewHolder>(MarsDiffCallback()) {
    class MarsViewHolder(
        val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MarsItem) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        return MarsViewHolder(
            ItemCardBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
}

class MarsDiffCallback : DiffUtil.ItemCallback<MarsItem>() {
    override fun areItemsTheSame(oldItem: MarsItem, newItem: MarsItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MarsItem, newItem: MarsItem): Boolean {
        return oldItem == newItem
    }
}


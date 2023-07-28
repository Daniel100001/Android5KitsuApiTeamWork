package com.example.android5kitsuapiteamwork.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android5kitsuapiteamwork.data.models.MangaModel
import com.example.android5kitsuapiteamwork.databinding.ItemKitsuBinding

class MangaAdapter :
    PagingDataAdapter<MangaModel, MangaAdapter.MangaViewHolder>(DiffUntilCallback()) {

    inner class MangaViewHolder(private val binding: ItemKitsuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: MangaModel?) {
            binding.itemCharacterName.text = item?.attributes?.title?.nameInJapanese
            Glide.with(binding.itemCharacterImage).load(item?.attributes?.posterImage?.original)
                .into(binding.itemCharacterImage)
        }
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            ItemKitsuBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    companion object {

        class DiffUntilCallback : DiffUtil.ItemCallback<MangaModel>() {
            override fun areItemsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MangaModel, newItem: MangaModel): Boolean {
                return oldItem == newItem
            }
        }
    }
}
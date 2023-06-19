package com.binayshaw7777.ionageassignment.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.binayshaw7777.ionageassignment.databinding.MoviesItemBinding
import com.binayshaw7777.ionageassignment.model.SearchResult
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

private var itemList: List<SearchResult> = ArrayList()

class MoviesAdapter(
    private val activity: Activity,
    private val listener: (SearchResult) -> Unit,
) : RecyclerView.Adapter<MoviesAdapter.ItemViewHolder>() {

    class ItemViewHolder(val binding: MoviesItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            MoviesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount() = itemList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        holder.binding.apply {

            movieName.text = item.title
            releaseDate.text = item.year

            Glide.with(activity)
                .load(item.posterLink)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imagePreview)

            root.setOnClickListener {
                listener(item)
            }
        }
    }

    fun submitList(fetchedList: List<SearchResult>?) {
        fetchedList?.let {
            clearList()
            itemList = it
            notifyDataSetChanged()
        }
    }

    fun clearList() {
        itemList = ArrayList()
        notifyDataSetChanged()
    }
}
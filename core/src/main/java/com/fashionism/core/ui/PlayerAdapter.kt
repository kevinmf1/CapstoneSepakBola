package com.fashionism.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fashionism.core.R
import com.fashionism.core.databinding.ItemPlayerBinding
import com.fashionism.core.domain.model.Player

@Suppress("unused", "unused")
class PlayerAdapter : ListAdapter<Player, PlayerAdapter.ListViewHolder>(PlayerDiffCallback) {

    var onItemClick: ((Player) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayerBinding.bind(itemView)
        fun bind(data: Player) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.photo)
                    .into(imgItemPhoto)
                tvItemName.text = data.name
                tvItemDescription.text = data.description
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(getItem(adapterPosition))
            }
        }
    }

    companion object PlayerDiffCallback : DiffUtil.ItemCallback<Player>() {
        override fun areItemsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem.idPlayer == newItem.idPlayer
        }

        override fun areContentsTheSame(oldItem: Player, newItem: Player): Boolean {
            return oldItem == newItem
        }
    }
}



//class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.ListViewHolder>() {
//
//    private var listData = ArrayList<Player>()
//    var onItemClick: ((Player) -> Unit)? = null
//
//    fun setData(newListData: List<Player>?) {
//        if (newListData == null) return
//        listData.clear()
//        listData.addAll(newListData)
//        notifyDataSetChanged()
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
//        ListViewHolder(
//            LayoutInflater.from(parent.context).inflate(R.layout.item_player, parent, false)
//        )
//
//    override fun getItemCount() = listData.size
//
//    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//        val data = listData[position]
//        holder.bind(data)
//    }
//
//    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        private val binding = ItemPlayerBinding.bind(itemView)
//        fun bind(data: Player) {
//            with(binding) {
//                Glide.with(itemView.context)
//                    .load(data.photo)
//                    .into(imgItemPhoto)
//                tvItemName.text = data.name
//                tvItemDescription.text = data.description
//            }
//        }
//
//        init {
//            binding.root.setOnClickListener {
//                onItemClick?.invoke(listData[adapterPosition])
//            }
//        }
//    }
//}
package com.databind.aquaholic.mvvmproandroid

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.databind.aquaholic.mvvmproandroid.databinding.RvItemRepoBinding
import com.databind.aquaholic.mvvmproandroid.model.Repository

class RepositoryRecyclerViewAdapter(
    private var items: ArrayList<Repository>,
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RvItemRepoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], listener)

    override fun getItemCount(): Int  = items.size

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class ViewHolder(private var binding: RvItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repo: Repository, listener: OnItemClickListener?) {
            binding.repository = repo
            if (listener != null) binding.root.setOnClickListener {  listener.onItemClick(layoutPosition) }
            binding.executePendingBindings()
        }
    }

}
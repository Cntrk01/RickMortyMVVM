package com.example.rickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rickandmortyapp.databinding.RickMortyLayoutBinding
import com.example.rickandmortyapp.models.RickMorty

class RickMortyPageAdapter:PagingDataAdapter<RickMorty, RickMortyPageAdapter.MyViewHolder>(diffCallback) {

    inner class MyViewHolder(val binding:RickMortyLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }
    companion object{
        val diffCallback=object : DiffUtil.ItemCallback<RickMorty>(){
            override fun areItemsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: RickMorty, newItem: RickMorty): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=getItem(position) //bu  methot Paging Data Adapter'dan gelecek

       holder.binding.apply {
           textView.text="${currentItem?.name}"
           imageView.load(currentItem?.image){
               crossfade(1000)
               crossfade(true)
           }
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(RickMortyLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

}
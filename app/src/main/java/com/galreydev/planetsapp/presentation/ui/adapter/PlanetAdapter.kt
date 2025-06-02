package com.galreydev.planetsapp.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.galreydev.planetsapp.data.model.Result
import com.galreydev.planetsapp.databinding.ItemPlanetBinding

class PlanetAdapter: ListAdapter<Result, PlanetAdapter.PlanetViewHolder>(PlanetDiffUtil()){

    inner class PlanetViewHolder(private val binding: ItemPlanetBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(planet: Result){
            with(binding) {
                tvPlanet.text = planet.name
                Glide.with(binding.root)
                    .load("https://static.wikia.nocookie.net/dcextendeduniverse/images/3/30/Daily_Planet_-_Logo.png/revision/latest?cb=20201006125356&path-prefix=es")
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .transform(CenterCrop(), RoundedCorners(20))
                    .into(ivPlanet)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlanetViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPlanetBinding.inflate(inflater, parent, false)
        return PlanetViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PlanetViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }
}

class PlanetDiffUtil: DiffUtil.ItemCallback<Result>(){
    override fun areItemsTheSame(
        oldItem: Result,
        newItem: Result
    ) = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: Result,
        newItem: Result
    ) = oldItem == newItem

}
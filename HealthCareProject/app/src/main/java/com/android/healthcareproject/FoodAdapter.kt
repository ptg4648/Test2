package com.android.healthcareproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.healthcareproject.FragmentHome.Companion.exerciseList
import com.android.healthcareproject.databinding.ItmeExcerciseBinding

class FoodAdapter(val exerciseData: ArrayList<FoodData>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItmeExcerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(exerciseData[position])
    }

    override fun getItemCount(): Int {
        return exerciseData.size
    }

    class ViewHolder(private val binding: ItmeExcerciseBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(food: FoodData) {
            //
            binding.tvName.text = food.foodName
            binding.tvTime.text = food.foodMemo
        }
    }
}
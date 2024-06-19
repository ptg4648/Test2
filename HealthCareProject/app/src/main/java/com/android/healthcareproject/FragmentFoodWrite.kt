package com.android.healthcareproject

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.healthcareproject.FragmentFood.Companion.foodList
import com.android.healthcareproject.FragmentHomeWrite.Companion.date
import com.android.healthcareproject.databinding.FragmentFoodBinding
import com.android.healthcareproject.databinding.FragmentFoodWriteBinding
import com.android.healthcareproject.databinding.FragmentHomeBinding

class FragmentFoodWrite : Fragment() {
    private lateinit var binding: FragmentFoodWriteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodWriteBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btSave.setOnClickListener {
            val food = binding.edFood.text.toString()
            val memo = binding.edMemo.text.toString()


            if (food.isNotEmpty() && memo.isNotEmpty()) {
                val foodData = FoodData(food, memo)
                foodList.add(foodData)
            }

            val fragment = FragmentFood()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(com.android.healthcareproject.R.id.layout_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }
}
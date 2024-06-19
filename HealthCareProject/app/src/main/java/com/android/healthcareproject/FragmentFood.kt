package com.android.healthcareproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.healthcareproject.databinding.FragmentFoodBinding
import com.android.healthcareproject.databinding.FragmentHomeBinding

class FragmentFood : Fragment() {
    private lateinit var binding: FragmentFoodBinding
    private lateinit var adapter: FoodAdapter

    companion object {
        var foodList: ArrayList<FoodData> = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFoodBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imAdd.setOnClickListener {
            // 다른 프레그먼트로 이동
            val fragment = FragmentFoodWrite()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }

        adapter = FoodAdapter(foodList)
        binding.reList.adapter = adapter
        binding.reList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
    }
}
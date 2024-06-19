package com.android.healthcareproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.healthcareproject.MainActivity.Companion.sharedPreferences
import com.android.healthcareproject.databinding.FragmentHomeBinding
import com.android.healthcareproject.databinding.FragmentProfileBinding

class FragmentProfile : Fragment() {
    private lateinit var binding: FragmentProfileBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getData()
        setEvent()
    }

    private fun getData() {
        val name = sharedPreferences.getString("name", "")
        val age = sharedPreferences.getString("age", "")
        val weight = sharedPreferences.getString("weight", "")
        val height = sharedPreferences.getString("height", "")
        val gender = sharedPreferences.getString("gender", "")

        binding.apply {
            edName.setText(name)
            edAge.setText(age)
            edWeight.setText(weight)
            edHeight.setText(height)
            edGender.setText(gender)
        }
    }

    private fun setEvent() {
        // 저장 버튼 클릭 시
        binding.btSave.setOnClickListener {
            val name = binding.edName.text.toString()
            val age = binding.edAge.text.toString()
            val weight = binding.edWeight.text.toString()
            val height = binding.edHeight.text.toString()
            val gender = binding.edGender.text.toString()


            // 입력한 값이 비어있지 않다면 저장
            if (age.isNotEmpty() && weight.isNotEmpty() && height.isNotEmpty() && gender.isNotEmpty() && name.isNotEmpty()) {
                sharedPreferences.edit().putString("name", name).apply()
                sharedPreferences.edit().putString("age", age).apply()
                sharedPreferences.edit().putString("weight", weight).apply()
                sharedPreferences.edit().putString("height", height).apply()
                sharedPreferences.edit().putString("gender", gender).apply()
            }

            // 다른 프레그먼트로 이동
            val fragment = FragmentHome()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }

}
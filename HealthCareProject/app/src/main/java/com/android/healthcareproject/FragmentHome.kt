package com.android.healthcareproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.healthcareproject.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: ExerciseAdapter

    companion object {
        var exerciseList: ArrayList<ExerciseData> = ArrayList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.imAdd.setOnClickListener {
            // 다른 프레그먼트로 이동
            val fragment = FragmentHomeWrite()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.layout_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
            fragmentManager.beginTransaction()
                .remove(this)
                .commit()
        }

        adapter = ExerciseAdapter(exerciseList)
        binding.reList.adapter = adapter
        binding.reList.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(requireContext())
    }
}
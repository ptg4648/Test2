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
import com.android.healthcareproject.FragmentHome.Companion.exerciseList
import com.android.healthcareproject.MainActivity.Companion.sharedPreferences
import com.android.healthcareproject.databinding.FragmentHomeBinding
import com.android.healthcareproject.databinding.FragmentHomeWriteBinding

class FragmentHomeWrite : Fragment() {
    private lateinit var binding: FragmentHomeWriteBinding

    private val dummyData = arrayOf(
        "벤치프레스",
        "스쿼트",
        "데드리프트",
        "풀업",
        "푸쉬업",
        "레그프레스",
        "레그컬",
        "레그익스텐션",
        "벤트오버로우",
        "프론트레이즈",
        "사이드레터럴레이즈",
        "숄더프레스",
        "인클라인벤치프레스",
        "디클라인벤치프레스",
        "인클라인덤벨프레스",
        "디클라인덤벨프레스",
        "인클라인플라이",
        "디클라인플라이",
        "플라이",
        "풀다운",
        "로우",
        "바벨컬",
        "힙쓰러스트",
        "더블힙쓰러스트",
        "런지",
        "사이드런지",
        "스쿼트점프",
        "버피",
        "바이시클",
        "레그레이즈",
        "플랭크",
        "사이드플랭크",
        "힙리프트",
        "더블힙리프트",
        "힙쓰러스트",
        "더블힙쓰러스트",
        "런지",
        "사이드런지",
    )

    companion object {
        var date = ""
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeWriteBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spExercise.adapter = context?.let {
            ArrayAdapter(
                it,
                R.layout.simple_spinner_dropdown_item,
                dummyData
            )
        }

        // spinner item selected listener
        binding.spExercise.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                Toast.makeText(context, selectedItem, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }


        // date picker button click listener
        binding.btDate.setOnClickListener {
            //show date picker dialog
            val newFragment = DatePickerFragment()
            newFragment.show(parentFragmentManager, "datePicker")
        }

        binding.btSave.setOnClickListener {
            val exercise = binding.spExercise.selectedItem.toString()
            val date = date

            // if exercise and date is not empty, add to exerciseList
            if (exercise.isNotEmpty() && date.isNotEmpty()) {
                val exercise = ExerciseData(exercise, date)
                exerciseList.add(exercise)
                Log.i("##INFO", "exerciseList: ${exercise}, ${date}")
            }

            val fragment = FragmentHome()
            val fragmentManager = requireActivity().supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(com.android.healthcareproject.R.id.layout_container, fragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()

        }
    }

}
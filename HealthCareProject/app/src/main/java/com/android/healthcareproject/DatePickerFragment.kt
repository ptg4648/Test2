package com.android.healthcareproject

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.android.healthcareproject.FragmentHomeWrite.Companion.date

public class DatePickerFragment : DialogFragment() , DatePickerDialog.OnDateSetListener {

    override fun onCreateDialog(savedInstanceState: Bundle?): DatePickerDialog {
        val c = java.util.Calendar.getInstance()
        val year = c.get(java.util.Calendar.YEAR)
        val month = c.get(java.util.Calendar.MONTH)
        val day = c.get(java.util.Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(), this, year, month, day)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        date = "$year-${month + 1}-$dayOfMonth"
        Toast.makeText(requireContext(), date, Toast.LENGTH_SHORT).show()
    }
}

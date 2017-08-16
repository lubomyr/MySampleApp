package com.sample.app.fragment_with_date_and_time_picker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.sample.app.R
import java.text.SimpleDateFormat
import java.util.*

class FragmentWithDateAndTimePicker : Fragment(), View.OnClickListener {
    private var etEmail: EditText? = null
    private var etDate: TextView? = null
    private var etTime: TextView? = null
    private var datePickerDialog: DatePickerDialog? = null
    private var timePickerDialog: TimePickerDialog? = null
    private var newDate: Calendar? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val rootView = inflater!!.inflate(R.layout.fragment_with_date_and_time_picker, container, false)

        bindView(rootView)
        addClickListeners()
        setDateTimeField()

        return rootView
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.input_date -> datePickerDialog!!.show()
            R.id.input_time -> timePickerDialog!!.show()
        }
    }

    private fun bindView(view: View) {
        etEmail = view.findViewById(R.id.input_email) as EditText
        etDate = view.findViewById(R.id.input_date) as TextView
        etTime = view.findViewById(R.id.input_time) as TextView
    }

    private fun addClickListeners() {
        etDate!!.setOnClickListener(this)
        etTime!!.setOnClickListener(this)
    }

    private fun setDateTimeField() {
        val newCalendar = Calendar.getInstance()
        datePickerDialog = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            newDate = Calendar.getInstance()
            newDate!!.set(year, monthOfYear, dayOfMonth)
            val dateFormatter = SimpleDateFormat("dd-MM-yyyy", Locale.US)
            etDate!!.text = dateFormatter.format(newDate!!.time)
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH))
        // Date cannot be in past (Passed date disabled in datepicker)
        datePickerDialog!!.datePicker.minDate = Date().time

        val zero = "0"
        timePickerDialog = TimePickerDialog(activity, TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
            val hoursStr = if (hourOfDay < 10) zero + hourOfDay else hourOfDay.toString()
            val minutesStr = if (minute < 10) zero + minute else minute.toString()
            etTime!!.text = String.format("%s:%s", hoursStr, minutesStr)
        }, newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true)

    }

    private fun confirmClicked() {
        if (validate()) {
            val email = etEmail!!.text.toString()
            val date = etDate!!.text.toString()
            val time = etTime!!.text.toString()
        }

    }

    private fun validate(): Boolean {
        var valid = true
        val email = etEmail!!.text.toString()
        val date = etDate!!.text.toString()

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail!!.error = getString(R.string.enter_valid_email)
            valid = false
        } else {
            etEmail!!.error = null
        }

        if (TextUtils.isEmpty(date)) {
            etDate!!.error = getString(R.string.select_date)
            valid = false
        } else {
            etDate!!.error = null
        }

        return valid
    }
}

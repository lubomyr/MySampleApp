package com.sample.app.fragment_with_date_and_time_picker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.sample.app.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class FragmentWithDateAndTimePicker extends Fragment  implements View.OnClickListener {
    private EditText etEmail;
    private TextView etDate;
    private TextView etTime;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;
    private Calendar newDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView      = inflater.inflate(R.layout.fragment_with_date_and_time_picker, container, false);

        bindView(rootView);
        addClickListeners();
        setDateTimeField();

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.input_date:
                datePickerDialog.show();
                break;
            case R.id.input_time:
                timePickerDialog.show();
                break;
        }
    }

    private void bindView(View view) {
        etEmail = (EditText) view.findViewById(R.id.input_email);
        etDate = (TextView) view.findViewById(R.id.input_date);
        etTime = (TextView) view.findViewById(R.id.input_time);
    }

    private void addClickListeners() {
        etDate.setOnClickListener(this);
        etTime.setOnClickListener(this);
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                etDate.setText(dateFormatter.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        // Date cannot be in past (Passed date disabled in datepicker)
        datePickerDialog.getDatePicker().setMinDate(new Date().getTime());

        final String zero = "0";
        timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String hoursStr = (hourOfDay < 10) ? zero + hourOfDay : String.valueOf(hourOfDay);
                String minutesStr = (minute < 10) ? zero + minute : String.valueOf(minute);
                etTime.setText(String.format("%s:%s", hoursStr, minutesStr));
            }
        }, newCalendar.get(Calendar.HOUR_OF_DAY), newCalendar.get(Calendar.MINUTE), true);

    }

    private void confirmClicked() {
        if (validate()) {
            String email = etEmail.getText().toString();
            String date = etDate.getText().toString();
            String time = etTime.getText().toString();
        }

    }

    private boolean validate() {
        boolean valid = true;
        String email = etEmail.getText().toString();
        String date = etDate.getText().toString();

        if (TextUtils.isEmpty(email) || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError(getString(R.string.enter_valid_email));
            valid = false;
        } else {
            etEmail.setError(null);
        }

        if (TextUtils.isEmpty(date)) {
            etDate.setError(getString(R.string.select_date));
            valid = false;
        } else {
            etDate.setError(null);
        }

        return valid;
    }
}

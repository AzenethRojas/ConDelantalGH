package com.condelantal.condelantal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        return  datePickerDialog;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        TextView tv1=(TextView) getActivity().findViewById(R.id.fecha);
        tv1.setText(view.getDayOfMonth()+"/"+(view.getMonth()+1)+"/"+view.getYear());
    }

}

package com.condelantal.condelantal;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 06/11/2016.
 */

public class ReservationActivity extends AppCompatActivity {

    int num_maxp;
    Toolbar mToolbar;
    Spinner  mesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mesa = (Spinner) findViewById(R.id.mesas);
        ReservationDAL reservationDAL = new ReservationDAL();
        num_maxp = reservationDAL.consultarNumMaxPersonas();
        ArrayList<Mesa> lstMesa = new ArrayList<Mesa>();
        lstMesa = reservationDAL.consultarMesas();
        NumberPicker np = (NumberPicker) findViewById(R.id.npPersons);
        String[] nums = new String[num_maxp+1];
        for (int i = 0; i < nums.length; i++)
            nums[i] = Integer.toString(i+1);

        np.setMinValue(1);
        np.setMaxValue(num_maxp);
        np.setWrapSelectorWheel(false);
        np.setDisplayedValues(nums);
        np.setValue(1);
        CustomMesaAdapter adapter = new CustomMesaAdapter(this,lstMesa);
        // apply the Adapter:
        mesa.setAdapter(adapter);
        Button btnSiguiente = (Button) findViewById(R.id.siguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NumberPicker np = (NumberPicker) findViewById(R.id.npPersons);
                EditText hora = (EditText) findViewById(R.id.hora);
                EditText fecha = (EditText) findViewById(R.id.fecha);
                Spinner  area = (Spinner) findViewById(R.id.area);
                String horaText =  hora.getText().toString();
                String fechaText =  fecha.getText().toString();
                Mesa mesaobj = (Mesa)mesa.getSelectedItem();
                if(np.getValue() != 0) {
                    if(!horaText.equals("") && !fechaText.equals(""))
                    {
                        Intent intent = new Intent(ReservationActivity.this, PedidoActivity.class);
                        intent.putExtra("cantidadPesonas", np.getValue());
                        intent.putExtra("hora",horaText);
                        intent.putExtra("fecha", fechaText);
                        intent.putExtra("area", area.getSelectedItem().toString());
                        intent.putExtra("mesa", mesaobj.getId());
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(), "Favor de escoger una hora y fecha.",Toast.LENGTH_SHORT).show();

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "La cantidad de personas no puede ser 0.",Toast.LENGTH_SHORT).show();

                }

            }

    });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int theId = item.getItemId();
        if (theId == android.R.id.home)
        {
            finish();
        }
        return true;
    }
    @Override
    public void onBackPressed() {
        finish();
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");

    }


}


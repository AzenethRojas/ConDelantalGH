package com.condelantal.condelantal;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 19/11/2016.
 */

public class ReservationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservations);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Toolbar mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Reservaciones");
        ListView lv = (ListView) findViewById(R.id.lstreservaciones);
        ReservationDAL reservationDAL = new ReservationDAL();
        ArrayList<resumenReservacion> lstReser= new ArrayList<resumenReservacion>();
        int clientID = ((Cliente)getApplication()).getClientId();
        lstReser = reservationDAL.getAllReservations(clientID);
        ReservationsListAdapter adapter = new ReservationsListAdapter(this,R.layout.reservations_info, lstReser);
        lv.setItemsCanFocus(true);
        lv.setAdapter(adapter);
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
}

package com.condelantal.condelantal;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class PrincipalActivity  extends AppCompatActivity  implements View.OnClickListener {
    Button sign;
    EditText correo, contrasena;
    int respuesta;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        Button btnReservar = (Button) findViewById(R.id.reservacion);
        btnReservar.setOnClickListener(this);

        Button btnMenu = (Button) findViewById(R.id.menu);
        btnMenu.setOnClickListener(this);

        Button btnMisReservaciones = (Button) findViewById(R.id.reservaciones);
        btnMisReservaciones.setOnClickListener(this);
    }
    public void onClick(View v) {
            // Perform action on click
            switch(v.getId()) {
                case R.id.reservacion:
                    Intent intent = new Intent(PrincipalActivity.this, ReservationActivity.class);
                    startActivity(intent);
                    break;
                case R.id.menu:
                    intent = new Intent(PrincipalActivity.this, MenuActivity.class);
                    startActivity(intent);
                    break;
                case R.id.reservaciones:
                    intent = new Intent(PrincipalActivity.this, ReservationsActivity.class);
                    startActivity(intent);
                    break;
            }
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.logout:
                Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

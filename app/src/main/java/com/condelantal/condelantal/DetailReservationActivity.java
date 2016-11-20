package com.condelantal.condelantal;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class DetailReservationActivity extends AppCompatActivity {

    int num_maxp;
    int canttotal;
    int num_platillos;
    Toolbar mToolbar;
    ListView lv;
    int np;
    String hora ;
    String fecha;
    String area ;
    int mesa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        mToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        lv = (ListView) findViewById(R.id.lstmenu);
        TextView txtarea = (TextView) findViewById(R.id.txtarea);
        TextView txtpersonas = (TextView) findViewById(R.id.txtpersonas);
        TextView txtmesa  = (TextView) findViewById(R.id.mesa);
        TextView total = (TextView) findViewById(R.id.total);
        MenuDAL menuDAL = new MenuDAL();
        Bundle bundle = getIntent().getExtras();
        ArrayList<Menu> lstMenu = (ArrayList<Menu>) bundle.getSerializable("pedido");
        np = bundle.getInt("cantidadPesonas");
        hora = bundle.getString("hora");
        fecha = bundle.getString("fecha");
        area = bundle.getString("area");
        mesa = bundle.getInt("mesa");

        txtarea.setText(area);
        txtpersonas.setText(String.valueOf(np));
        txtmesa.setText(String.valueOf(mesa));
        for(int i=0;i<lstMenu.size();i++){
            Menu menu = lstMenu.get(i);
            if(menu.isSelected()){
                canttotal += menu.getSubtotal();
                num_platillos += menu.getCantidad();
            }
        }
        Iterator<Menu> i = lstMenu.iterator();
        while (i.hasNext()) {
            Menu s = i.next(); // must be called before you can call i.remove()
            // Do something
            if(!s.isSelected()) {
                i.remove();
            }
        }

        CustomMenuAdapter adapter = new CustomMenuAdapter(this,R.layout.pedido_info, lstMenu);
        lv.setItemsCanFocus(true);
        lv.setAdapter(adapter);
        total.setText("$ " + canttotal);

    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();

                return true;
            case R.id.action_save:
                ReservationDAL reservationDAL = new ReservationDAL();
                int clientID = ((Cliente)getApplication()).getClientId();
                int reservacionID = reservationDAL.insertarReservacion(np,hora,fecha.toString(),area.toString(),false,clientID,mesa);
                int pedidoID = reservationDAL.insertarPedido(canttotal,false,clientID,reservacionID);
                reservationDAL.insertarConsumo(num_platillos,mesa,pedidoID);
                Toast.makeText(getApplicationContext(), "Reservación agendada.",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailReservationActivity.this, PrincipalActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

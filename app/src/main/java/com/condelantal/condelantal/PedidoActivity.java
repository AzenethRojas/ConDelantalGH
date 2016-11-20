package com.condelantal.condelantal;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class PedidoActivity extends AppCompatActivity {

    int num_maxp;
    Toolbar mToolbar;
    ListView lv;
    int np;
    String hora ;
    String fecha;
    String area ;
    int mesa;
    CustomAdapter adapter;
    ArrayList<Menu> menulist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido);
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
        MenuDAL menuDAL = new MenuDAL();
        ArrayList<Menu> lstMenu= new ArrayList<Menu>();
        lstMenu = menuDAL.consultarMenu();
        adapter = new CustomAdapter(this,R.layout.menu_info, lstMenu);
        lv.setItemsCanFocus(true);
        lv.setAdapter(adapter);
        Button btnSiguiente = (Button) findViewById(R.id.btnsiguiente);
        Bundle bundle = getIntent().getExtras();
        np = bundle.getInt("cantidadPesonas");
        hora = bundle.getString("hora");
        fecha = bundle.getString("fecha");
        area = bundle.getString("area");
        mesa = bundle.getInt("mesa");
        menulist = adapter.lstMenu;

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PedidoActivity.this, DetailReservationActivity.class);
                intent.putExtra("cantidadPesonas", np);
                intent.putExtra("hora", hora);
                intent.putExtra("fecha", fecha);
                intent.putExtra("area", area);
                intent.putExtra("mesa", mesa);
                intent.putExtra("pedido", menulist);
                startActivity(intent);

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
}

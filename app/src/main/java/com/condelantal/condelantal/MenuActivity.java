package com.condelantal.condelantal;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class MenuActivity extends AppCompatActivity {

    int num_maxp;
    Toolbar mToolbar;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
        CustomPedidoAdapter adapter = new CustomPedidoAdapter(this,R.layout.menuall_info, lstMenu);
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

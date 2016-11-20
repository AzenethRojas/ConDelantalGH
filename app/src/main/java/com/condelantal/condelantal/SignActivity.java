package com.condelantal.condelantal;

/**
 * Created by Azeneth Rojas on 29/10/2016.
 */

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
public class SignActivity extends AppCompatActivity{
    Button sign;
    EditText correo, contrasena;
    int respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        sign = (Button) findViewById(R.id.Sign);
        correo = (EditText) findViewById(R.id.correo);
        contrasena = (EditText) findViewById(R.id.contrasena);

        sign.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

                LoginDAL loginDAL = new LoginDAL();
                RegisterDAL registerDAL = new RegisterDAL();
                respuesta = loginDAL.consultarUsuario(correo.getText().toString(),contrasena.getText().toString());
                if(respuesta == 1)
                {
                    Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
                     respuesta = registerDAL.consultarClienteId(correo.getText().toString(),contrasena.getText().toString());
                    ((Cliente)getApplication()).setClientId(respuesta);
                    Intent intent = new Intent(SignActivity.this, PrincipalActivity.class);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Usuario incorrecto",Toast.LENGTH_SHORT).show();

                }

            }
        });




    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

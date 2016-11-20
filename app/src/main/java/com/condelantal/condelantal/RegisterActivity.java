package com.condelantal.condelantal;

import android.app.DialogFragment;
import android.app.Fragment;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.ClientInfoStatus;

public class RegisterActivity extends AppCompatActivity implements  INewUserName
{

    EditText correo, contrasena, celular, nombre;
    int respuesta;
    FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        setContentView(R.layout.activity_register);
        Button btnAceptar = (Button) findViewById(R.id.Aceptar);
        correo = (EditText) findViewById(R.id.correo);
        contrasena = (EditText) findViewById(R.id.contrasena);
        celular = (EditText) findViewById(R.id.celular);
        nombre = (EditText) findViewById(R.id.nombre);

        btnAceptar.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v) {

                //verficar si ya existe el correo en la tabla de clientes
                RegisterDAL registerDAL = new RegisterDAL();
                if(!correo.getText().toString().equals("") && !contrasena.getText().toString().equals("") && !celular.getText().toString().equals("") && !nombre.getText().toString().equals("") ) {
                    respuesta = registerDAL.consultarCliente(correo.getText().toString());

                    if (respuesta == 0) {

                        //verficar si el nuevo nombre de usuario no exista en la tabla de usuarios
                        String userName = correo.getText().toString().split("@")[0];
                        respuesta = registerDAL.consultarUsuario(userName);
                        if (respuesta == 0) {
                            //si no agregar  en la tabla de usuario el nombre de usuario su correo antes del @ en caso contrario mandarlo a la pagina de crear usuario
                            respuesta = registerDAL.insertarUsuarioCliente(userName, contrasena.getText().toString());
                            registerDAL.insertarCliente(nombre.getText().toString(), celular.getText().toString(), correo.getText().toString(), contrasena.getText().toString(), respuesta);
                            respuesta = registerDAL.consultarClienteId(userName, contrasena.getText().toString());
                            ((Cliente) getApplication()).setClientId(respuesta);
                            Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(RegisterActivity.this, PrincipalActivity.class);
                            startActivity(intent);

                        } else {
                            NewUserNameFragment alertdFragment = new NewUserNameFragment();
                            alertdFragment.show(fm, "Alert Dialog Fragment");

                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Correo ya registrado.", Toast.LENGTH_SHORT).show();

                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Favor de ingresar todos los campos.", Toast.LENGTH_SHORT).show();

                }



            }
        });




    }
    @Override
    public void okButtonClicked(String  userName)
    {
        RegisterDAL registerDAL = new RegisterDAL();
        respuesta = registerDAL.insertarUsuarioCliente(userName,contrasena.getText().toString());
        registerDAL.insertarCliente(nombre.getText().toString(),celular.getText().toString(),correo.getText().toString(),contrasena.getText().toString(),respuesta);
        respuesta = registerDAL.consultarClienteId(userName,contrasena.getText().toString());
        Cliente mApp = ((Cliente)getApplicationContext());
        mApp.setClientId(respuesta);
        Toast.makeText(getApplicationContext(), "Redirecting...",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(RegisterActivity.this, PrincipalActivity.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}

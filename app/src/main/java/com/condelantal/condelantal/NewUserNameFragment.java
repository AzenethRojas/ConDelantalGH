package com.condelantal.condelantal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Toast;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by Azeneth Rojas on 12/11/2016.
 */

public class NewUserNameFragment extends DialogFragment {
    INewUserName iNewUserName;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.activity_newusername, null))
                // Add action buttons
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // user ...
                        RegisterDAL registerDAL = new RegisterDAL();

                        EditText userName = (EditText) getDialog().findViewById(R.id.username);
                        int respuesta = registerDAL.consultarUsuario(userName.getText().toString());
                        if(respuesta == 1)
                        {
                            Toast.makeText(getApplicationContext(), "Usuario ya existe..",Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            ((RegisterActivity)getActivity()).okButtonClicked(userName.getText().toString());

                        }

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        NewUserNameFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}

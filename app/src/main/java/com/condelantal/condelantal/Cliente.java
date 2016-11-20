package com.condelantal.condelantal;

import android.app.Activity;
import android.app.Application;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Azeneth Rojas on 16/11/2016.
 */

public class Cliente extends Application {

    private int clientId;

    public int getClientId(){
        return clientId;
    }
    public void setClientId(int s){
        clientId = s;
    }
}

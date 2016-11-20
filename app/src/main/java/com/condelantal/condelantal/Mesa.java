package com.condelantal.condelantal;

/**
 * Created by Azeneth Rojas on 14/11/2016.
 */

public class Mesa {


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getNumMaxPersonas() {
        return numMaxPersonas;
    }

    public void setNumMaxPersonas(int numMaxPersonas) {
        this.numMaxPersonas = numMaxPersonas;
    }

    public int id ;
    public String numero ;
    public boolean libre ;
    public int numMaxPersonas ;
}

package com.condelantal.condelantal;

/**
 * Created by Azeneth Rojas on 19/11/2016.
 */

public class resumenReservacion {

    public String hora ;
    public String fecha ;
    public String area ;
    public int cant_personas ;
    public int subtotal;
    public int platillos ;
    public int mesa ;


    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getCant_personas() {
        return cant_personas;
    }

    public void setCant_personas(int cant_personas) {
        this.cant_personas = cant_personas;
    }

    public int getPlatillos() {
        return platillos;
    }

    public void setPlatillos(int platillos) {
        this.platillos = platillos;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }


    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

}

package com.condelantal.condelantal;

import java.io.Serializable;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class Menu implements Serializable {
    public int id = 0;
    public String nombre = null;
    public int precio = 0;
    public boolean selected = false ;
    public int cantidad = 0;
    public int subtotal = 0;

    public Menu(int id, String nombre,int precio,int cantidad, int subtotal, boolean selected){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.selected = selected;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }
    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }


}

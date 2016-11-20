package com.condelantal.condelantal;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 13/11/2016.
 */

public class CustomMenuAdapter extends ArrayAdapter<Menu> {

    private ArrayList<Menu> lstMenu;
    Context context;

    public CustomMenuAdapter(Context context, int textViewResourceId,
                         ArrayList<Menu> lstMenu) {
        super(context, textViewResourceId, lstMenu);
        this.lstMenu = new ArrayList<Menu>();
        this.lstMenu.addAll(lstMenu);
        this.context = context;
    }

    private class ViewHolder {
        TextView pedido;
        TextView cantidad;
        TextView subtotal;
        int ref;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder ;

        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = ((Activity)context).getLayoutInflater();
            convertView = vi.inflate(R.layout.pedido_info, parent, false);
            holder = new ViewHolder();
            holder.pedido = (TextView) convertView.findViewById(R.id.pedido);
            holder.cantidad = (TextView) convertView.findViewById(R.id.cantidad);
            holder.subtotal = (TextView) convertView.findViewById(R.id.subtotal);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Menu menu = lstMenu.get(position);
        if(menu.isSelected()) {
            holder.cantidad.setText(String.valueOf(menu.getCantidad()));
            holder.pedido.setText(menu.getNombre());
            holder.subtotal.setText(" $ " + menu.getSubtotal());
        }
        return convertView;

    }

}


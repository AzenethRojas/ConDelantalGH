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

public class CustomAdapter extends ArrayAdapter<Menu> {

    public ArrayList<Menu> lstMenu;
    Context context;

    public CustomAdapter(Context context, int textViewResourceId,
                           ArrayList<Menu> lstMenu) {
        super(context, textViewResourceId, lstMenu);
        this.lstMenu = new ArrayList<Menu>();
        this.lstMenu.addAll(lstMenu);
        this.context = context;
    }

    private class ViewHolder {
        TextView pedido;
        CheckBox chkpedido;
        EditText cantidad;
        TextView subtotal;
        int ref;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder ;

        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = ((Activity)context).getLayoutInflater();
            convertView = vi.inflate(R.layout.menu_info, parent, false);
            holder = new ViewHolder();
            holder.pedido = (TextView) convertView.findViewById(R.id.pedido);
            holder.chkpedido = (CheckBox) convertView.findViewById(R.id.chkPedido);
            holder.cantidad = (EditText) convertView.findViewById(R.id.cantidad);
            holder.subtotal = (TextView) convertView.findViewById(R.id.subtotal);
            convertView.setTag(holder);

            holder.chkpedido.setOnClickListener( new View.OnClickListener() {
                public void onClick(View v) {
                    CheckBox cb = (CheckBox) v ;
                    Menu menu = (Menu) cb.getTag();
                    menu.setSelected(cb.isChecked());
                }
            });
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        Menu menu = lstMenu.get(position);
        holder.pedido.setText(" ( $ " +  menu.getPrecio() + ") ");
        holder.ref = position;
        holder.chkpedido.setText(menu.getNombre());
        holder.chkpedido.setChecked(menu.isSelected());
        holder.chkpedido.setTag(menu);
        holder.cantidad.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                Menu menu = lstMenu.get(holder.ref);
                if(!s.toString().equals("")) {
                    menu.setCantidad(Integer.parseInt(s.toString()));
                }else
                {
                    menu.setCantidad(0);
                }
                menu.setSubtotal( menu.getPrecio() * menu.getCantidad());
                holder.subtotal.setText(" ( $ " +  menu.getSubtotal() + ") ");
            }
        });
        return convertView;

    }

}

package com.condelantal.condelantal;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 19/11/2016.
 */

public class ReservationsListAdapter extends ArrayAdapter<resumenReservacion> {

    private ArrayList<resumenReservacion> lstRese;
    Context context;

    public ReservationsListAdapter(Context context, int textViewResourceId,
                             ArrayList<resumenReservacion> lstRese) {
        super(context, textViewResourceId, lstRese);
        this.lstRese = new ArrayList<resumenReservacion>();
        this.lstRese.addAll(lstRese);
        this.context = context;
    }

    private class ViewHolder {
        TextView fecha;
        TextView hora;
        TextView subtotal;
        TextView platillos;
        TextView mesa;
        TextView cant_personas;
        TextView area;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder ;

        Log.v("ConvertView", String.valueOf(position));

        if (convertView == null) {
            LayoutInflater vi = ((Activity)context).getLayoutInflater();
            convertView = vi.inflate(R.layout.reservations_info, parent, false);
            holder = new ViewHolder();
            holder.fecha = (TextView) convertView.findViewById(R.id.fechalbl);
            holder.hora = (TextView) convertView.findViewById(R.id.horalbl);
            holder.subtotal = (TextView) convertView.findViewById(R.id.totallbl);
            holder.cant_personas = (TextView) convertView.findViewById(R.id.personaslbl);
            holder.mesa = (TextView) convertView.findViewById(R.id.mesabl);
            holder.area = (TextView) convertView.findViewById(R.id.arealbl);
            holder.platillos = (TextView) convertView.findViewById(R.id.platilloslbl);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
        resumenReservacion rese = lstRese.get(position);
        holder.fecha.setText(rese.getFecha());
        holder.hora.setText(rese.getHora());
        holder.cant_personas.setText(String.valueOf(rese.getCant_personas()));
        holder.platillos.setText(String.valueOf(rese.getPlatillos()));
        holder.area.setText(rese.getArea());
        holder.mesa.setText(String.valueOf(rese.getMesa()));
        holder.subtotal.setText(String.valueOf(rese.getSubtotal()));
        return convertView;

    }

}

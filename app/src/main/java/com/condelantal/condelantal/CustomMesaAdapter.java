package com.condelantal.condelantal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Azeneth Rojas on 14/11/2016.
 */

public class CustomMesaAdapter  extends BaseAdapter implements SpinnerAdapter {



    public ArrayList<Mesa> lstMesa;
    Context context;

    public CustomMesaAdapter(Context context,
                         ArrayList<Mesa> lstMesa) {
        this.lstMesa = new ArrayList<Mesa>();
        this.lstMesa.addAll(lstMesa);
        this.context = context;
    }
    @Override
    public int getCount() {
        return lstMesa.size();
    }

    /**
     * Returns one Element of the ArrayList
     * at the specified position.
     */
    @Override
    public Object getItem(int position) {
        return lstMesa.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    /**
     * Returns the View that is shown when a element was
     * selected.
     */
    @Override
    public View getView(int position, View recycle, ViewGroup parent) {
        TextView text;
        if (recycle != null){
            // Re-use the recycled view here!
            text = (TextView) recycle;
        } else {
            // No recycled view, inflate the "original" from the platform:
            text = (TextView) ((Activity)context).getLayoutInflater().inflate(
                    android.R.layout.simple_dropdown_item_1line, parent, false
            );
        }
        text.setTextColor(Color.BLACK);
        text.setText(lstMesa.get(position).numero);
        return text;
    }
}

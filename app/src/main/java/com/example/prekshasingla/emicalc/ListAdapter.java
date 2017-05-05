package com.example.prekshasingla.emicalc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by prekshasingla on 05/05/17.
 */
public class ListAdapter extends ArrayAdapter<EMI> {
    public ArrayList<EMI> EMIList;

    public ListAdapter(Context context, ArrayList<EMI> list) {
        super(context, 0,list);
        EMIList=list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        EMI emi = (EMI)getItem(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.listitem, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = new ViewHolder(convertView);
        }
        viewHolder.t1.setText(""+emi.TENURE);
        viewHolder.t2.setText(""+emi.EMI);
        viewHolder.t3.setText(""+emi.TOTAL);

        return convertView;
    }
    public static class ViewHolder {

        TextView t1;
        TextView t2;
        TextView t3;

        public ViewHolder(View view) {
            t1= (TextView) view.findViewById(R.id.list_item_text1);
            t2= (TextView) view.findViewById(R.id.list_item_text2);
            t3= (TextView) view.findViewById(R.id.list_item_text3);

        }
    }
}

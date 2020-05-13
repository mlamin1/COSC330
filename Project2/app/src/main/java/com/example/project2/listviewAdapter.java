package com.example.project2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class listviewAdapter extends BaseAdapter {

    public ArrayList<Model> productList;
    Activity activity;

    public listviewAdapter(MainAct activity, ArrayList<Model> productList) {
        super();
        this.activity = activity;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView sym;
        TextView nam;
        TextView las;
        TextView dat;
        TextView tim;
        TextView ope;
        TextView hig;
        TextView vol;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        LayoutInflater inflater = activity.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.listview_row, null);
            holder = new ViewHolder();
            holder.sym = (TextView) convertView.findViewById(R.id.symbol);
            holder.nam = (TextView) convertView.findViewById(R.id.name);
            holder.las = (TextView) convertView.findViewById(R.id.last);
            holder.dat = (TextView) convertView.findViewById(R.id.date);
            holder.tim = (TextView) convertView.findViewById(R.id.times);
            holder.ope = (TextView) convertView.findViewById(R.id.open);
            holder.hig = (TextView) convertView.findViewById(R.id.high);
            holder.vol = (TextView) convertView.findViewById(R.id.vol);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Model item = productList.get(position);
        holder.sym.setText(item.getSymbol().toString());
        holder.nam.setText(item.getName().toString());
        holder.las.setText(item.getLast().toString());
        holder.dat.setText(item.getDate().toString());
        holder.tim.setText(item.getTime().toString());
        holder.ope.setText(item.getOpen().toString());
        holder.hig.setText(item.getHigh().toString());
        holder.vol.setText(item.getVolume().toString());

        return convertView;
    }

}

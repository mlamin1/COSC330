package com.example.project_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String Chapter[];
    int Logo[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] Chapter, int[] Logo) {
        this.context = applicationContext;
        this.Chapter = Chapter;
        this.Logo = Logo;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return Chapter.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView Chap = (TextView) view.findViewById(R.id.textView);
        ImageView LOGOS = (ImageView) view.findViewById(R.id.icon);
        Chap.setText(Chapter[i]);
        LOGOS.setImageResource(Logo[i]);
        return view;
    }
}
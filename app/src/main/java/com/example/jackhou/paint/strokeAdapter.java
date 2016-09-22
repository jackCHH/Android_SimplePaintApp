package com.example.jackhou.paint;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class strokeAdapter extends BaseAdapter {

    String[] strings;
    Context context;

    public strokeAdapter(String[] strings, Context context){
        this.strings = strings;
        this.context = context;
    }

    @Override
    public int getCount(){
        return strings.length;
    }

    @Override
    public String getItem(int position){
        return strings[position];
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        TextView textview = new TextView(context);
        textview.setText(strings[position]);

        switch(position){
            case 0:
                textview.setTextSize(15);
                break;
            case 1:
                textview.setTextSize(20);
                break;
            case 2:
                textview.setTextSize(25);
                break;
            case 3:
                textview.setTextSize(30);
                break;
            case 4:
                textview.setTextSize(35);
                break;
        }

        return textview;

    }
}

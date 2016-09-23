package com.example.jackhou.paint;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class colorAdapter extends BaseAdapter {

    String[] strings;
    Context context;

    public colorAdapter(String[] strings, Context context){
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

        // todo: textView.setBackgroundColor(presenter.getColorForPosition(psoition));

        textview.setTextColor(Color.TRANSPARENT);
        switch(position){
            case 0:
                textview.setBackgroundColor(Color.BLACK);
                break;
            case 1:
                textview.setBackgroundColor(Color.RED);
                break;
            case 2:
                textview.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                textview.setBackgroundColor(Color.GREEN);
                break;
            case 4:
                textview.setBackgroundColor(Color.CYAN);
                break;
            case 5:
                textview.setBackgroundColor(Color.BLUE);
                break;
            case 6:
                textview.setBackgroundColor(Color.MAGENTA);
                break;
        }

        return textview;

    }


}

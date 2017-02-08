package com.example.bruger.mobilesystemproject;
/*
    Inspiration from Nevethan's Bachelor Project (SmartBrace)
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nevethan on 20-11-2016.
 * Inspired from Nevethan's Bachelor Projects (SmartBrace)
 */

public class CustomList extends ArrayAdapter<String> {

    //private final Activity context;
    private final String[] titles;
    private final Integer[] imageId;

    //public CustomList(Context context, String[] points, Integer[] imageId)
    public CustomList(Context context, String[] titles, Integer[] imageId) {
        super(context, R.layout.customlist, titles);
        this.titles = titles;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.customlist, parent, false);

        TextView title = (TextView) row.findViewById(R.id.textView6);

        ImageView imgView = (ImageView) row.findViewById(R.id.img);
        title.setText(titles[position]);
        title.setTextColor(Color.BLACK);

        imgView.setImageResource(imageId[position]);
        return row;
    }
}

package com.example.bruger.mobilesystemproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Bruger on 20-11-2016.
 */

public class CustomList extends ArrayAdapter<String> {

    //private final Activity context;
    private final String[] points;
    //private final Integer[] imageId;

    //public CustomList(Context context, String[] points, Integer[] imageId)
    public CustomList(Context context, String[] points) {
        super(context, R.layout.customlist, points);
        this.points = points;
        //this.imageId = imageId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View row = layoutInflater.inflate(R.layout.customlist, parent, false);

        TextView title = (TextView) row.findViewById(R.id.textView6);

        //ImageView imgView = (ImageView) row.findViewById(R.id.img);
        title.setText(points[position]);

        //imgView.setImageResource(imageId[position]);
        return row;
    }
}

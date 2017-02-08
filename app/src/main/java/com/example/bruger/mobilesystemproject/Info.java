package com.example.bruger.mobilesystemproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/*
    Inspiration from Nevethan's Bachelor Project (SmartBrace)
 */
public class Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        TextView showInfo = (TextView) findViewById(R.id.textView9);
        TextView showTitle = (TextView) findViewById(R.id.textView7);

        showTitle.setText("Information");

        String info = " \n" + "The Harry Potter Festival is a recurrent event that takes place in the Danish autumbreak (week 42).\n" +
                "The festival is organized by Odense bibliotekerne (Odense libraries) in corporation with a number of cultural actors.\n" +
                "There are around 10.000 people participating the festival.\n" +
                " \n" +
                " \n" +

                "Tickets\n" +
                " \n" +
                "Galleons\n" +
                " \n" +
                "Parking\n" +
                " \n" +
                "WC’s\n" +
                " \n" +
                "Photography\n" +
                " \n" +
                "Information\n" +
                " \n" +
                "Dining\n" +
                " \n" +
                "Activities\n";

        showInfo.setText(info);
        showInfo.setTextColor(Color.BLACK);

    }
}

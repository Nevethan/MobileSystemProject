package com.example.bruger.mobilesystemproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Viewpoints extends AppCompatActivity {

    ListView listView;

    String[] points = {
            "point 1",
            "point 2",
            "point 3",
            "point 4"
    };

    /*Integer[] imageId = {
            R.drawable.squat,
            R.drawable.knee_stabilization,
            R.drawable.quadriceps_stretch,
            R.drawable.side_lying_leg_lift
    };*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpoints);


        ListAdapter listAdapter = new CustomList(this, points);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


                //Description of each viewpoint when it is clicked...




                Toast.makeText(Viewpoints.this, "You Clicked at " + points[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }


}

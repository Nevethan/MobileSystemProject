package com.example.bruger.mobilesystemproject;
/*
    Inspiration from Nevethan's Bachelor Project (SmartBrace)
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class EventSpots extends AppCompatActivity {

    ListView listView;

    String[] titles = {
            "HogwartsExpress - Platorm 9 3/4",
            "Internatinal Quidditch-Tournament",
            "Hogwarts",
            "Hagrid Story Telling",
            "The Magical Marketplace",
            "Diagon Alley",
            "Scribbles With Rita",
            "The Chamber of Secrets",
            "OFF to Hogwarts",
            "The Leaky Cauldron and Honeydukes",
            "The Restricted Section of the Library",
            "Broom Workshop",
            "The Enchanced Labyrinth",
            "Snape's Elixir Workshop"
    };

    Integer[] imageId = {
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo,
            R.drawable.hp_logo
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpoints);


        ListAdapter listAdapter = new CustomList(this, titles, imageId);
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(EventSpots.this, titles[+position], Toast.LENGTH_SHORT).show();
            }
        });
    }


}

package com.example.bruger.mobilesystemproject;
/*
    Inspiration from Nevethan's Bachelor Project (SmartBrace)
 */

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Options extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        TextView showuser = (TextView) findViewById(R.id.textView8);
        String user;

        Bundle extras = getIntent().getExtras();

        user = extras.getString("username");

        showuser.setText(user);
    }

    public void viewEvents(View view){
        Intent intent = new Intent(this, EventSpots.class);
        startActivity(intent);
    }

    public void viewMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

    public void viewInfo(View view){
        Intent intent = new Intent(this, Info.class);
        startActivity(intent);
    }

    public void logout(View view){
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.clear();
        editor.commit();

        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}

package com.example.bruger.mobilesystemproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Options extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void viewpoints(View view){
        Intent intent = new Intent(this, Options.class);
        startActivity(intent);
    }

    public void viewMap(View view){
        Intent intent = new Intent(this, Map.class);
        startActivity(intent);
    }
}

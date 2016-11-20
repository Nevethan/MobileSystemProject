package com.example.bruger.mobilesystemproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class Login extends AppCompatActivity {


    DatabaseManager dbManager = new DatabaseManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void login(View view){

        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.password);

        String userInput = username.getText().toString();
        String passInput = password.getText().toString();

        String pass = dbManager.searchDb(userInput);

        //Checks whether the EditTexts are blank or not. If they are, the uer will be warned
        if(!userInput.isEmpty() && !passInput.isEmpty()){
            if(passInput.equals(pass)){
                Intent intent = new Intent(this, Options.class);
                startActivity(intent);
            }else{
                makeText(getApplicationContext(), "The Username or Password is wrong. Please try again", LENGTH_SHORT).show();
            }
        }else{
            makeText(getApplicationContext(), "Please Enter Username and Password", LENGTH_SHORT).show();
        }
    }

    //Action to start the Activity_sign_up
    public void register(View view){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }



}

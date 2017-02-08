package com.example.bruger.mobilesystemproject;
/*
    Inspiration from Nevethan's Bachelor Project (SmartBrace)
 */
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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
                intent.putExtra("username", userInput);
                startActivityForResult(intent,0);
            }else{
                Toast.makeText(getApplicationContext(), "The Username or Password is wrong. Please try again", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
        }
    }

    //Action to start the Activity_sign_up
    public void signUp(View view){
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }

}

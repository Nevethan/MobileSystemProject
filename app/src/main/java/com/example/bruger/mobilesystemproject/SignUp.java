package com.example.bruger.mobilesystemproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {


    DatabaseManager dbManager = new DatabaseManager(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void onSignUp(View view) {

        //if the button if pressed, Android will receive the inputs.
        if (view.getId() == R.id.signUp) {
            EditText username = (EditText) findViewById(R.id.signUsername);
            EditText password = (EditText) findViewById(R.id.signPassword);

            String usernameInput = username.getText().toString();
            String passwordInput = password.getText().toString();


            // In case the EditTexts are blank, the statement is to warn the user to write some inputs.

            if (!usernameInput.isEmpty() && !passwordInput.isEmpty()) {
                User user = new User();
                user.setUsername(usernameInput);
                user.setPassword(passwordInput);

                dbManager.insert(user);
                Toast.makeText(getApplicationContext(), "Register Complete", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(this, Login.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Please Enter Username and Password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

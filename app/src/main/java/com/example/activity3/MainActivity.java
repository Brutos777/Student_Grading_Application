package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Login");
    }

    public void onClickLogin(View v) {

        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);

        String USERNAME = edtUsername.getText().toString();
        String PASSWORD = edtPassword.getText().toString();

        String username = "tricia";
        String password = "tricia";


        if ((edtUsername.length() == 0) || (edtPassword.length() == 0)) {
            if (edtUsername.length() == 0) {
                edtUsername.setError("Enter your username");
            }
            if (edtPassword.length() == 0) {
                edtPassword.setError("Enter your password");
            }
        }


        if (!(edtUsername.length() == 0) || !(edtPassword.length() == 0)) {
            if (USERNAME.equals(username) && PASSWORD.equals(password)) {
                Intent i = new Intent(this, MenuActivity.class);
                startActivity(i);
            } else if (!(USERNAME.equals(username)) || !(PASSWORD.equals(password))) {
                Toast t = Toast.makeText(getApplicationContext(), "Wrong Username or Password", Toast.LENGTH_LONG);
                t.show();
            }
        }

    }


}
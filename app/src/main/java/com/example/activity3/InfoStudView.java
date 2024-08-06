package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InfoStudView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_stud_view);
        setTitle("Student Information View");

        Intent i = getIntent();
        String lastName = i.getStringExtra("FIRSTNAME");
        String firstName = i.getStringExtra("LASTNAME");
        String course = i.getStringExtra("COURSE");
        int year = i.getIntExtra("YEAR", 0);
        String emailAddress = i.getStringExtra("EMAILADDRESS");
        int contactNum = i.getIntExtra("CONTACTNUMBER", 0);
        int birthYear = i.getIntExtra("BIRTHYEAR", 0);

        TextView txtLastName = findViewById(R.id.txtLastName);
        TextView txtFirstName = findViewById(R.id.txtFirstName);
        TextView txtCourse = findViewById(R.id.txtCourse);
        TextView txtYear = findViewById(R.id.txtYear);
        TextView txtEmailAddress = findViewById(R.id.txtEmailAddress);
        TextView txtContactNum = findViewById(R.id.txtContactNum);
        TextView txtBirthYear = findViewById(R.id.txtBirthYear);
        TextView txtAge = findViewById(R.id.txtAge);

        int age = 2023 - birthYear;

        txtLastName.setText("Lastname: " + lastName);
        txtFirstName.setText("Firstname: " + firstName);
        txtCourse.setText("Course: " + course);
        txtYear.setText("Year: " + String.valueOf(year) + " year");
        txtEmailAddress.setText("Email Address: " + emailAddress);
        txtContactNum.setText("Contact Number: +63" + String.valueOf(contactNum));
        txtBirthYear.setText("Birthyear: " + String.valueOf(birthYear));
        txtAge.setText("Age: " + String.valueOf(age) + " years old");

    }

    public void returnMenu(View v) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }


}
package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class InfoStudGradeView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_stud_grade_view);
        setTitle("Student Grade View");

        Intent i = getIntent();
        String lastname = i.getStringExtra("LASTNAME");
        String firstname = i.getStringExtra("FIRSTNAME");
        int attendance = i.getIntExtra("ATTENDANCE", 0);
        int quiz1 = i.getIntExtra("QUIZ1", 0);
        int quiz2 = i.getIntExtra("QUIZ2", 0);
        int quiz3 = i.getIntExtra("QUIZ3", 0);
        int quiz4 = i.getIntExtra("QUIZ4", 0);
        int exam = i.getIntExtra("EXAM", 0);

        TextView txtlastname = findViewById(R.id.txtLastnameGrade);
        TextView txtfirstname = findViewById(R.id.txtFirstnameGrade);
        TextView txtattendance = findViewById(R.id.txtAttendance);
        TextView txtquiz1 = findViewById(R.id.txtQuiz1);
        TextView txtquiz2 = findViewById(R.id.txtQuiz2);
        TextView txtquiz3 = findViewById(R.id.txtQuiz3);
        TextView txtquiz4 = findViewById(R.id.txtQuiz4);
        TextView txtexam = findViewById(R.id.txtExam);
        TextView txtaverage = findViewById(R.id.txtAverage);
        TextView txtStatus = findViewById(R.id.txtStatus);
        TextView txtRemarks = findViewById(R.id.txtRemarks);

        double attendScore = attendance * .20;

        double quizzes = quiz1 + quiz2 + quiz3 + quiz4;
        double quizzesdiv = quizzes / 4;
        double totalQuizzes = quizzesdiv * .30;

        double examScore = exam * .50;

        double average = attendScore + totalQuizzes + examScore;


        if (average <= 74) {
            txtStatus.setText("Status: Failed");
        } else {
            txtStatus.setText("Status: Passed");
        }


        if (average <= 100 && average >= 97) {
            txtRemarks.setText("Remarks: 1.00");
        } else if (average <= 96 && average >= 94) {
            txtRemarks.setText("Remarks: 1.25");
        } else if (average <= 93 && average >= 91) {
            txtRemarks.setText("Remarks: 1.50");
        } else if (average <= 90 && average >= 88) {
            txtRemarks.setText("Remarks: 1.75");
        } else if (average <= 87 && average >= 85) {
            txtRemarks.setText("Remarks: 2.00");
        } else if (average <= 84 && average >= 82) {
            txtRemarks.setText("Remarks: 2.25");
        } else if (average <= 81 && average >= 79) {
            txtRemarks.setText("Remarks: 1.75");
        } else if (average <= 78 && average >= 76) {
            txtRemarks.setText("Remarks: 2.75");
        } else if (average == 75) {
            txtRemarks.setText("Remarks: 3.00");
        } else if (average <= 74){
            txtRemarks.setText("Remarks: 5.00");
        }

        txtlastname.setText("Lastname: " + lastname);
        txtfirstname.setText("Firstname: " + firstname);
        txtattendance.setText("Attendance: " + String.valueOf(attendance));
        txtquiz1.setText("Quiz 1: " + String.valueOf(quiz1));
        txtquiz2.setText("Quiz 2: " + String.valueOf(quiz2));
        txtquiz3.setText("Quiz 3: " + String.valueOf(quiz3));
        txtquiz4.setText("Quiz 4: " + String.valueOf(quiz4));
        txtexam.setText("Exam: " + String.valueOf(exam));
        txtaverage.setText("Average: " + String.valueOf(average));

    }

    public void onClickReturn(View v) {
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }


}
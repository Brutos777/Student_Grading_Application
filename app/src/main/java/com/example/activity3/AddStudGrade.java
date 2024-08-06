package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddStudGrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stud_grade);
        setTitle("Student Grade");

    }

    public void Submit(View v) {

        EditText edtLastname = findViewById(R.id.edtLastname);
        EditText edtFirstname = findViewById(R.id.edtFirstname);
        EditText edtAttendance = findViewById(R.id.edtAttendance);
        EditText edtQuiz1 = findViewById(R.id.edtQuiz1);
        EditText edtQuiz2 = findViewById(R.id.edtQuiz2);
        EditText edtQuiz3 = findViewById(R.id.edtQuiz3);
        EditText edtQuiz4 = findViewById(R.id.edtQuiz4);
        EditText edtExam = findViewById(R.id.edtExam);

        if (edtLastname.length() == 0 || edtFirstname.length() == 0 || edtAttendance.length() == 0 || edtQuiz1.length() == 0 ||
                edtQuiz2.length() == 0 || edtQuiz3.length() == 0 || edtQuiz4.length() == 0 || edtExam.length() == 0) {
            if (edtLastname.length() == 0) {

                edtLastname.setError("Shouldn't be blank");

            } else if (edtFirstname.length() == 0) {

                edtFirstname.setError("Shouldn't be blank");

            } else if (edtAttendance.length() == 0) {

                edtAttendance.setError("Shouldn't be blank");

            } else if (edtQuiz1.length() == 0) {

                edtQuiz1.setError("Shouldn't be blank");

            } else if (edtQuiz2.length() == 0) {

                edtQuiz2.setError("Shouldn't be blank");

            } else if (edtQuiz3.length() == 0) {

                edtQuiz3.setError("Shouldn't be blank");

            } else if (edtQuiz4.length() == 0) {

                edtQuiz4.setError("Shouldn't be blank");

            } else if (edtExam.length() == 0) {

                edtExam.setError("Shouldn't be blank");

            }
        } else if (!(edtLastname.length() == 0) || !(edtFirstname.length() == 0) || !(edtAttendance.length() == 0) || !(edtQuiz1.length() == 0) ||
                !(edtQuiz2.length() == 0) || !(edtQuiz3.length() == 0) || !(edtQuiz4.length() == 0) || !(edtExam.length() == 0)) {

            String lastname = edtLastname.getText().toString();
            String firstname = edtFirstname.getText().toString();
            int attendance = Integer.parseInt(edtAttendance.getText().toString());
            int quiz1 = Integer.parseInt(edtQuiz1.getText().toString());
            int quiz2 = Integer.parseInt(edtQuiz2.getText().toString());
            int quiz3 = Integer.parseInt(edtQuiz3.getText().toString());
            int quiz4 = Integer.parseInt(edtQuiz4.getText().toString());
            int exam = Integer.parseInt(edtExam.getText().toString());

            if (attendance < 1 || attendance > 100) {

                Toast t = Toast.makeText(getApplicationContext(), "Attendance should not exceed 100 and not less than 1", Toast.LENGTH_LONG);
                t.show();

            } else if (quiz1 < 1 || quiz1 > 100) {

                Toast t = Toast.makeText(getApplicationContext(), "Quiz 1 score should not exceed 100 and not less than 1", Toast.LENGTH_LONG);
                t.show();

            } else if (quiz2 < 1 || quiz2 > 100) {

                Toast t = Toast.makeText(getApplicationContext(), "Quiz 2 score should not exceed 100 and not less than 1", Toast.LENGTH_LONG);
                t.show();

            } else if (quiz3 < 1 || quiz3 > 100) {

                Toast t = Toast.makeText(getApplicationContext(), "Quiz 3 score should not exceed 100 and not less than 1", Toast.LENGTH_LONG);
                t.show();

            } else if (quiz4 < 1 || quiz4 > 100) {

                Toast t = Toast.makeText(getApplicationContext(), "Quiz 4 score should not exceed 100 and not less than 1", Toast.LENGTH_LONG);
                t.show();

            } else if (exam < 1 || exam > 100) {

                Toast t = Toast.makeText(getApplicationContext(), "Exam score should not exceed 100 and not less than 1", Toast.LENGTH_LONG);
                t.show();

            } else {

                NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
                builder.setContentTitle("View Grade");
                builder.setContentText(lastname);
                builder.setSmallIcon(R.drawable.baseline_check_circle_24);
                builder.setAutoCancel(true);

                Intent i = new Intent(this, InfoStudGradeView.class);
                i.putExtra("LASTNAME", lastname);
                i.putExtra("FIRSTNAME", firstname);
                i.putExtra("ATTENDANCE", attendance);
                i.putExtra("QUIZ1", quiz1);
                i.putExtra("QUIZ2", quiz2);
                i.putExtra("QUIZ3", quiz3);
                i.putExtra("QUIZ4", quiz4);
                i.putExtra("EXAM", exam);

                PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pi);

                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0, builder.build());


            }


        }


    }


}
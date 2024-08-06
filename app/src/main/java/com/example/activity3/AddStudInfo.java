package com.example.activity3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddStudInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stud_info);
        setTitle("Student Information");
    }

    public void onClickSubmit(View v) {

        EditText edtLastName = findViewById(R.id.edtLastName);
        EditText edtFirstName = findViewById(R.id.edtFirstName);
        EditText edtCourse = findViewById(R.id.edtCourse);
        EditText edtYear = findViewById(R.id.edtYear);
        EditText edtEmailAddress = findViewById(R.id.edtEmailAddress);
        EditText edtContactNum = findViewById(R.id.edtContactNum);
        EditText edtBirthyear = findViewById(R.id.edtBirthYear);

        if (edtLastName.length() == 0 || edtFirstName.length() == 0 || edtCourse.length() == 0 || edtYear.length() == 0 ||
                edtEmailAddress.length() == 0 || edtContactNum.length() == 0 || edtBirthyear.length() == 0) {
            if (edtLastName.length() == 0) {

                edtLastName.setError("Shouldn't be blank");

            } else if (edtFirstName.length() == 0) {

                edtFirstName.setError("Shouldn't be blank");

            } else if (edtCourse.length() == 0) {

                edtCourse.setError("Shouldn't be blank");

            } else if (edtYear.length() == 0) {

                edtYear.setError("Shouldn't be blank");

            } else if (edtEmailAddress.length() == 0) {

                edtEmailAddress.setError("Shouldn't be blank");

            } else if (edtContactNum.length() == 0) {

                edtContactNum.setError("Shouldn't be blank");

            } else if (edtBirthyear.length() == 0) {

                edtBirthyear.setError("Shouldn't be blank");

            }
        } else if (!(edtLastName.length() == 0) || !(edtFirstName.length() == 0) || !(edtCourse.length() == 0) || !(edtYear.length() == 0) ||
                !(edtEmailAddress.length() == 0) || !(edtContactNum.length() == 0) || !(edtBirthyear.length() == 0)) {

            String firstName = edtFirstName.getText().toString();
            String lastName = edtLastName.getText().toString();
            String course = edtCourse.getText().toString();
            int year = Integer.parseInt(edtYear.getText().toString());
            String emailAddress = edtEmailAddress.getText().toString();
            int contactNum = Integer.parseInt(edtContactNum.getText().toString());
            int birthYear = Integer.parseInt(edtBirthyear.getText().toString());

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setContentTitle("View Information");
            builder.setContentText(lastName);
            builder.setSmallIcon(R.drawable.baseline_check_circle_24);
            builder.setAutoCancel(true);

            Intent i = new Intent(this, InfoStudView.class);
            i.putExtra("FIRSTNAME", firstName);
            i.putExtra("LASTNAME", lastName);
            i.putExtra("COURSE", course);
            i.putExtra("YEAR", year);
            i.putExtra("EMAILADDRESS", emailAddress);
            i.putExtra("CONTACTNUMBER", contactNum);
            i.putExtra("BIRTHYEAR", birthYear);

            PendingIntent pi = PendingIntent.getActivity(this, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pi);

            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            nm.notify(0, builder.build());


        }


    }


}
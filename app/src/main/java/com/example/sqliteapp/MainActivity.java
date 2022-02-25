package com.example.sqliteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText courseNamaEdt, courseNimEdt, courseJurusanEdt, courseFakultasEdt;
    private Button addCourseBtn;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        courseNamaEdt = findViewById(R.id.idEdtCourseNama);
        courseNimEdt = findViewById(R.id.idEdtCourseNim);
        courseJurusanEdt = findViewById(R.id.idEdtCourseJurusan);
        courseFakultasEdt = findViewById(R.id.idEdtCourseFakultas);
        addCourseBtn = findViewById(R.id.idBtnAddCourse);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        addCourseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String courseNama = courseNamaEdt.getText().toString();
                String courseNim = courseNimEdt.getText().toString();
                String courseJurusan = courseJurusanEdt.getText().toString();
                String courseFakultas = courseFakultasEdt.getText().toString();

                // validating if the text fields are empty or not.
                if (courseNama.isEmpty() && courseNim.isEmpty() && courseJurusan.isEmpty() && courseFakultas.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Silahkan Lengkapi Data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(courseNama, courseNim, courseJurusan, courseFakultas);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Data Berhasil Ditambahkan", Toast.LENGTH_SHORT).show();
                courseNamaEdt.setText("");
                courseNimEdt.setText("");
                courseJurusanEdt.setText("");
                courseFakultasEdt.setText("");
            }
        });
    }
}

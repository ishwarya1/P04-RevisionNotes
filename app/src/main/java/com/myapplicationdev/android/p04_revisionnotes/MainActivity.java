package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etnote;
    Button btninsert, btnshow;
    RadioGroup rgstars;
    RadioButton rbstars;
    int yes = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btninsert = findViewById(R.id.buttonInsertNote);
        btnshow= findViewById(R.id.buttonShowList);
        etnote = findViewById(R.id.editTextNote);
        rgstars = findViewById(R.id.radioGroupStars);

        btninsert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                yes = rgstars.getCheckedRadioButtonId();
                rbstars = (RadioButton)findViewById(yes);
                int num = Integer.parseInt(rbstars.getText().toString());
                // Create the DBHelper object, passing in the
                // activity's Context
                DBHelper db = new DBHelper(MainActivity.this);

                // Insert a task
                db.insertNote(etnote.getText().toString(), num);
                db.close();
                Toast.makeText(MainActivity.this, "Inserted", Toast.LENGTH_SHORT).show();
            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(intent);
            }
        });


    }
}

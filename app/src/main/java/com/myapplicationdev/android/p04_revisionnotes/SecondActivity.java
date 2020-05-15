package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
	ListView lv;
	ArrayAdapter adapter;
	ArrayList<Note> noteDisplay = new ArrayList<Note>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		lv = (ListView)findViewById(R.id.lv);

		loadValues();


		adapter = new RevisionNotesArrayAdapter(getApplicationContext(),R.layout.row,noteDisplay);
		lv.setAdapter(adapter);



	}

	private void loadValues() {
		DBHelper db = new DBHelper(SecondActivity.this);
		// Insert a task
		ArrayList<Note> data = db.getAllNotes();
		db.close();
		for (int i = 0; i < data.size(); i++) {
			noteDisplay.add(new Note(data.get(i).getId(), data.get(i).getNoteContent(), data.get(i).getStars()));
		}

	}


}

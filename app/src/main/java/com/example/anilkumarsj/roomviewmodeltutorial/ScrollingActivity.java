package com.example.anilkumarsj.roomviewmodeltutorial;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.UUID;

public class ScrollingActivity extends AppCompatActivity {

    private static final int NEW_NOTE_ACTIVITY_REQUEST_CODE = 1;
    private String TAG = this.getClass().getSimpleName();

    NoteViewModel noteViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ScrollingActivity.this,NewNoteActivity.class);

                startActivityForResult(intent,NEW_NOTE_ACTIVITY_REQUEST_CODE);
            }
        });





        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_NOTE_ACTIVITY_REQUEST_CODE && resultCode ==RESULT_OK){

            //code to insert notes

            final String note_id = UUID.randomUUID().toString();

            Note note = new Note(note_id,data.getStringExtra(NewNoteActivity.NOTE_ADDED));

            noteViewModel.insert(note);

            Toast.makeText(getApplicationContext(),"Note saved to database",Toast.LENGTH_LONG).show();
        }
        else {

            Toast.makeText(getApplicationContext(),"Note  not saved to database",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

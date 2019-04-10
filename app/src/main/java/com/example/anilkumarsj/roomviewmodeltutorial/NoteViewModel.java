package com.example.anilkumarsj.roomviewmodeltutorial;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

public class NoteViewModel extends AndroidViewModel {


    private String TAG = this.getClass().getSimpleName();

    private NoteDao noteDao;
    private  NoteRoomDatabase noteDB;

    public NoteViewModel(@NonNull Application application) {

        super(application);

        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDB.noteDao();
    }

    public void insert(Note note){

        new  InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.i(TAG,"ViewModel Destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<Note,Void,Void>{

        NoteDao mNoteDao;

        public InsertAsyncTask(NoteDao noteDao) {

            this.mNoteDao = noteDao;

        }

        @Override
        protected Void doInBackground(Note... notes) {

            mNoteDao.insert(notes[0]);
            return null;
        }
    }
}

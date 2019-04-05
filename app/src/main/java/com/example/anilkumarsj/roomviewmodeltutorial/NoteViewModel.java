package com.example.anilkumarsj.roomviewmodeltutorial;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

public class NoteViewModel extends AndroidViewModel {


    private String Tag = this.getClass().getSimpleName();

    public NoteViewModel(@NonNull Application application) {
        super(application);
    }

    @Override
    protected void onCleared() {
        super.onCleared();

        Log.i(Tag,"ViewModel Destroyed");
    }
}

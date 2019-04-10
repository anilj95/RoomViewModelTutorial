package com.example.anilkumarsj.roomviewmodeltutorial;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);
}

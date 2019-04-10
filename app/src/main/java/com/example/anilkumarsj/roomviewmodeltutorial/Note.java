package com.example.anilkumarsj.roomviewmodeltutorial;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "notes")

public class Note {

@PrimaryKey
@NonNull
    private  String id;

@NonNull
@ColumnInfo(name = "note")
    private  String eNote;


    public Note(@NonNull String id, @NonNull String eNote) {
        this.id = id;
        this.eNote = eNote;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String geteNote() {
        return eNote;
    }

    public void seteNote(@NonNull String eNote) {
        this.eNote = eNote;
    }
}

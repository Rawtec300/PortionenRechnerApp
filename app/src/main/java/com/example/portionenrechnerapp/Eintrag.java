package com.example.portionenrechnerapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Eintrag {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private final String word;

    public Eintrag(String word) {
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }
}

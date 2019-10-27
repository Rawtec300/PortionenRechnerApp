package com.example.portionenrechnerapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Eintrag {

    @PrimaryKey
    public int id;

    public String grammAlt;
    public String grammNeu;
    public String portionenAlt;
    public String portionenNeu;

    public Eintrag(String pGrammAlt, String pPortionenAlt, String pPortionenNeu, String pGrammNeu) {
        this.grammAlt = pGrammAlt;
        this.grammNeu = pGrammNeu;
        this.portionenAlt = pPortionenAlt;
        this.portionenNeu = pPortionenNeu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrammAlt() {
        return this.grammAlt;
    }


    public String getGrammNeu() {
        return this.grammNeu;
    }


    public String getPortionenAlt() {
        return this.portionenAlt;
    }


    public String getPortionenNeu() {
        return this.portionenAlt;
    }
}

package com.example.portionenrechnerapp;

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

    public Eintrag(String grammAlt, String portionenAlt, String portionenNeu, String grammNeu) {
        this.grammAlt = grammAlt;
        this.grammNeu = grammNeu;
        this.portionenAlt = portionenAlt;
        this.portionenNeu = portionenNeu;
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

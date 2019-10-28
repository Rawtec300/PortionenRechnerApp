package com.example.portionenrechnerapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Eintrag {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public double grammAlt;
    public double grammNeu;
    public double portionenAlt;
    public double portionenNeu;

    public Eintrag(double grammAlt, double portionenAlt, double portionenNeu, double grammNeu) {
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

    public double getGrammAlt() {
        return this.grammAlt;
    }


    public double getGrammNeu() {
        return this.grammNeu;
    }


    public double getPortionenAlt() {
        return this.portionenAlt;
    }


    public double getPortionenNeu() {
        return this.portionenAlt;
    }

    public String getEintrag(){
        return "(" + getGrammAlt() + "/" + getPortionenAlt() + ") * " + getPortionenNeu() + " = " + getGrammNeu();
    }
}

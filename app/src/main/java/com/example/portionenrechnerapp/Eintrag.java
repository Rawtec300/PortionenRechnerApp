package com.example.portionenrechnerapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Eintrag {

    @PrimaryKey(autoGenerate = true)
    public int id;

    private double grammAlt;
    private double grammNeu;
    private double portionenAlt;
    private double portionenNeu;

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
        return this.portionenNeu;
    }


    public String getGrammAltString() {
        String grammAltString = Double.toString(this.grammAlt);
        return grammAltString;
    }

    public String getGrammNeuString() {
        String grammNeuString = Double.toString(this.grammNeu);
        return grammNeuString;
    }

    public String getPortionenAltString() {
        String portionenAltString = Double.toString(this.portionenAlt);
        return portionenAltString;
    }

    public String getPortionenNeuString() {
        String portionenNeuString = Double.toString(this.portionenNeu);
        return portionenNeuString;
    }
}

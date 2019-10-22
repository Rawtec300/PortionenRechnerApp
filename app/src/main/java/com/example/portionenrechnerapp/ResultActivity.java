package com.example.portionenrechnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView portionenNeuBerechne;
    TextView grammNeuBerechne;
    Button zurueck;
    double erg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        portionenNeuBerechne = findViewById(R.id.text_berechne_portionen);
        grammNeuBerechne = findViewById(R.id.text_berechne_gramm);
        zurueck = findViewById(R.id.button_berechne_zurück);
        zurueck.setOnClickListener(this);

        Intent intentBerechne = getIntent();
        Bundle bundle = intentBerechne.getExtras();
        String portionNeuString = bundle.getString("portionen_neu_zu_berechne");
        String portionAltString = bundle.getString("portionen_alt_zu_berechne");
        String grammAltString = bundle.getString("gramm_alt_zu_berechne");

        double grammAltDouble = Double.parseDouble(grammAltString);
        double portionAltDouble = Double.parseDouble(portionAltString);
        double portionNeuDouble = Double.parseDouble(portionNeuString);

        erg = ( grammAltDouble / portionAltDouble ) * portionNeuDouble;
        String ergString = String.valueOf(erg);

        portionenNeuBerechne.setText(portionNeuString);
        grammNeuBerechne.setText(ergString);
    }

    @Override
    public void onClick(View view) {
        if (view == zurueck) {
            finish();
        }
    }
}

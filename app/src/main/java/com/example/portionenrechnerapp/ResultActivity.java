package com.example.portionenrechnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    TextView ergView;
    Button zurueck;
    public double erg;
    private EintragDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ergView = findViewById(R.id.text_ergebnis);
        zurueck = findViewById(R.id.button_berechne_zurück);
        zurueck.setOnClickListener(this);

        dao = EintragDatabase.getDatabase(this).eintragDao();

        Intent intentBerechne = getIntent();
        Bundle bundle = intentBerechne.getExtras();
        String portionNeuString = bundle.getString("portionen_neu_zu_berechne");
        String portionAltString = bundle.getString("portionen_alt_zu_berechne");
        String grammAltString = bundle.getString("gramm_alt_zu_berechne");

        double grammAltDouble = Double.parseDouble(grammAltString);
        double portionAltDouble = Double.parseDouble(portionAltString);
        double portionNeuDouble = Double.parseDouble(portionNeuString);

        erg = (grammAltDouble / portionAltDouble) * portionNeuDouble;
        String ergString = String.valueOf(erg);

        ergView.setText("Sie benötigen für " + portionNeuString + " Portionen " + ergString + " Gramm.");

        //TODO: Speichern soll in die ResultActivity durchgeführt werden

        new ResultActivity.SpeichernTask().execute(new Eintrag(
                grammAltDouble, portionAltDouble,
                portionNeuDouble, erg));
    }

    @Override
    public void onClick(View view) {
        if (view == zurueck) {
            finish();
        }
    }

    public String getErg(){
       return String.valueOf(erg);
    }
    class SpeichernTask extends AsyncTask<Eintrag, Void, Void> {

        @Override
        protected Void doInBackground(Eintrag... eintraege) {
            dao.insert(eintraege[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }
}

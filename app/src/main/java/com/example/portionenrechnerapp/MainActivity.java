package com.example.portionenrechnerapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button berechne;
    Button hilfe;
    Button anzeigen;
    EditText grammAlt;
    EditText portionAlt;
    EditText portionNeu;

    // private EintragDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // dao = EintragDatabase.getDatabase(this).eintragDao();

        berechne = findViewById(R.id.button_berechne);
        hilfe = findViewById(R.id.button_hilfe);
        anzeigen = findViewById(R.id.button_anzeigen);

        grammAlt = findViewById(R.id.word_edit_gramm_alt);
        portionAlt = findViewById(R.id.word_edit_portionen_alt);
        portionNeu = findViewById(R.id.word_edit_portionen_neu);
        berechne.setOnClickListener(this);
        hilfe.setOnClickListener(this);
        anzeigen.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String s = ".";
        if (view == berechne) {
            //Prüfen ob alle Textfelder ausgefüllt sind
            if (!portionAlt.getText().toString().isEmpty() && Integer.parseInt(portionAlt.getText().toString()) == 0) {
                Toast.makeText(getApplicationContext(), "Die alte Portionenanzahl darf nicht 0 sein!", Toast.LENGTH_SHORT).show();

            } else if (!(grammAlt.getText().toString().isEmpty() ||
                    portionAlt.getText().toString().isEmpty() ||
                    portionNeu.getText().toString().isEmpty())) {
                if (grammAlt.getText().charAt(0) != '.') {

                    Intent intentBerechne = new Intent(this, ResultActivity.class);
                    intentBerechne.putExtra("portionen_neu_zu_berechne", portionNeu.getText().toString());
                    intentBerechne.putExtra("portionen_alt_zu_berechne", portionAlt.getText().toString());
                    intentBerechne.putExtra("gramm_alt_zu_berechne", grammAlt.getText().toString());
                    startActivity(intentBerechne);
                    ResultActivity temp = new ResultActivity();
                    Double grammNeu = temp.erg;
              /*  //TODO: Speichern soll in die ResultActivity durchgeführt werden

                    new SpeichernTask().execute(new Eintrag(
                            Double.parseDouble(grammAlt.getText().toString()),
                            Double.parseDouble(portionAlt.getText().toString()),
                            Double.parseDouble(portionNeu.getText().toString()),
                            grammNeu));

*/
                }else{
                    Toast.makeText(getApplicationContext(), "Geben Sie bitte bei der ursprünglichen Grammzahl einen korrekten Wert ein", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Bitte geben Sie alle Werte ein!", Toast.LENGTH_SHORT).show();
            }
        } else if (view == hilfe) {
            Intent intentHelpPage = new Intent(this, Help_page.class);
            startActivity(intentHelpPage);
        } else if (view == anzeigen) {
            Intent intentAnzeigen = new Intent(this, AuflistungActivity.class);
            startActivity(intentAnzeigen);

        } else {
            Toast.makeText(getApplicationContext(), "Fehler, bitte neu starten!", Toast.LENGTH_SHORT).show();
        }
    }

    public EditText getGrammAlt() {
        return grammAlt;
    }

    public EditText getPortionAlt() {
        return portionAlt;
    }

    public EditText getPortionNeu() {
        return portionNeu;
    }

}

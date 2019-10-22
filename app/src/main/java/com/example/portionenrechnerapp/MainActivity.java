package com.example.portionenrechnerapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button berechne;
    Button hilfe;
    EditText grammAlt;
    EditText portionAlt;
    EditText portionNeu;
    TextView ergView;
    int erg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        berechne = findViewById(R.id.button_berechne);
        hilfe = findViewById(R.id.button_hilfe);

        grammAlt = findViewById(R.id.word_edit_gramm_alt);
        portionAlt = findViewById(R.id.word_edit_portionen_alt);
        portionNeu = findViewById(R.id.word_edit_portionen_neu);
        ergView = findViewById(R.id.text_berechne);
        berechne.setOnClickListener(this);
        hilfe.setOnClickListener(this);
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
        if (view == berechne) {
            if (!(grammAlt.getText().toString().isEmpty() || portionAlt.getText().toString().isEmpty() || portionNeu.getText().toString().isEmpty())) {
                int grammAltInt = Integer.parseInt(grammAlt.getText().toString());
                int portionAltInt = Integer.parseInt(portionAlt.getText().toString());
                int portionNeuInt = Integer.parseInt(portionNeu.getText().toString());
                if (portionAltInt == 0) {
                    Toast.makeText(getApplicationContext(), "Die alte Portionenanzahl darf nicht 0 sein!", Toast.LENGTH_LONG).show();
                } else {
                    erg = (grammAltInt / portionAltInt) * portionNeuInt;
                    String ergString = String.valueOf(erg);
                    ergView.setText(ergString);
                }
            } else {
                Toast.makeText(getApplicationContext(), "Bitte geben Sie alle Werte ein!", Toast.LENGTH_SHORT).show();
            }
        } else if (view == hilfe) {
            Intent intent_help_page = new Intent(this, Help_page.class);
            startActivity(intent_help_page);
        } else {
            Toast.makeText(getApplicationContext(), "Fehler, bitte neu starten!", Toast.LENGTH_SHORT).show();
        }
    }
}

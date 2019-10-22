package com.example.portionenrechnerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Help_page extends AppCompatActivity implements View.OnClickListener {
    Button zurück;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);
        zurück = findViewById(R.id.button_zurück);
        zurück.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == zurück) {
            finish();
        }
    }
}

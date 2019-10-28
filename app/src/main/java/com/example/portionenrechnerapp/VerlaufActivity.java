package com.example.portionenrechnerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;

public class VerlaufActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    ArrayList<String> eintraege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlauf);

        recyclerView = findViewById(R.id.recycler_view);

        eintraege = new ArrayList<>();

        for (int i = 0; i <10; i++) {
            eintraege.add("Test Nr: "+i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EintragAdapter(eintraege);
        recyclerView.setAdapter(adapter);
    }
}

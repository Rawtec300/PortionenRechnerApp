package com.example.portionenrechnerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class VerlaufActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verlauf);

        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EintragAdapter();
        recyclerView.setAdapter(adapter);
    }
}

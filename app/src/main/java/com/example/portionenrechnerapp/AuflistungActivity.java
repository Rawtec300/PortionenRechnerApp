package com.example.portionenrechnerapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AuflistungActivity extends AppCompatActivity implements View.OnClickListener {
    private EintragDao dao;
    private EintragListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_list);

        RecyclerView recyclerView = findViewById(R.id.eintraege_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EintragListAdapter();
        recyclerView.setAdapter(adapter);

        dao = EintragDatabase.getDatabase(this).eintragDao();

    }

    @Override
    public void onClick(View view){

    }
    @Override
    protected void onResume() {
        super.onResume();
        new LadeEintraegeTask().execute();
    }

    public class LadeEintraegeTask extends AsyncTask<View, View, List<Eintrag>> {

        @Override
        protected List<Eintrag> doInBackground(View... views) {
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<Eintrag> eintraege) {
            super.onPostExecute(eintraege);
            adapter.setEintraege(eintraege);
        }
    }
}

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
    private EintragListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_list);

        RecyclerView eintragRecyclerView = findViewById(R.id.eintraege_recycler);
        eintragRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new EintragListAdapter(EintragDatabase.getDatabase(this).eintragDao());
        eintragRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view){

    }
    @Override
    protected void onResume() {
        super.onResume();
        new LadeEintraegeTask(EintragDatabase.getDatabase(this).eintragDao(), adapter).execute();
    }

    public class LadeEintraegeTask extends AsyncTask<Void, Void, List<Eintrag>> {

        private EintragDao eintragDao;
        private EintragListAdapter adapter;

        LadeEintraegeTask(EintragDao eintragDao, EintragListAdapter adapter){
            this.eintragDao = eintragDao;
            this.adapter = adapter;
        }

        @Override
        protected List<Eintrag> doInBackground(Void... voids) {
            return eintragDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Eintrag> eintraege) {
            super.onPostExecute(eintraege);
            adapter.setEintraege(eintraege);
        }
    }
}

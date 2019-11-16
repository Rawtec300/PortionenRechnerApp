package com.example.portionenrechnerapp;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

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
        adapter = new EintragListAdapter(dao);
        recyclerView.setAdapter(adapter);

        dao = EintragDatabase.getDatabase(this).eintragDao();

    }

    @Override
    public void onClick(View view){

    }
    @Override
    protected void onResume() {
        super.onResume();
        new LadeEintraegeTask(dao, adapter).execute();
    }

    static class LadeEintraegeTask extends AsyncTask<Void, Void, List<Eintrag>> {

       private final EintragDao dao;
       private final EintragListAdapter adapter;

       public LadeEintraegeTask(EintragDao dao, EintragListAdapter adapter){
           this.dao = dao;
           this.adapter = adapter;
       }

        @Override
        protected List<Eintrag> doInBackground(Void... voids) {
            return dao.getAll();
        }


    }

}

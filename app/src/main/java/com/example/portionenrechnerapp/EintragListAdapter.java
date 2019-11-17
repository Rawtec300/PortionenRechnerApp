package com.example.portionenrechnerapp;

import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class EintragListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Eintrag> eintraege = Collections.emptyList();
    private final EintragDao eintragDao;

    EintragListAdapter(EintragDao eintragDao){
        this.eintragDao = eintragDao;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.eintrag_list_item, parent, false);
        return new EintragViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Button loesche = holder.itemView.findViewById(R.id.button_loeschen);
        TextView eintragView = holder.itemView.findViewById(R.id.list_item_eintrag);
        //TextView altGramm = holder.itemView.findViewById(R.id.rv_alte_grammzahl);
        eintragView.setText(eintraege.get(position).getEintrag());
        //altGramm.setText(eintraege.get(position));

        holder.itemView.setOnClickListener((view) -> {
            new DeleteEintragTask(eintragDao, this).execute(eintraege.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return eintraege.size();
    }

    void setEintraege(List<Eintrag> eintraege){
        this.eintraege = eintraege;
        notifyDataSetChanged();
    }

    static class DeleteEintragTask extends AsyncTask<Eintrag, Void, List<Eintrag>>{

        private final EintragDao eintragDao;
        private EintragListAdapter eintragListAdapter;

        DeleteEintragTask(EintragDao eintragDao, EintragListAdapter eintragListAdapter){
            this.eintragDao = eintragDao;
            this.eintragListAdapter = eintragListAdapter;
        }

        @Override
        protected List<Eintrag> doInBackground(Eintrag... eintraege) {
            Eintrag eintragLöschen = eintraege[0];
            eintragDao.delete(eintragLöschen);
            return eintragDao.getAll();
        }

        @Override
        protected void onPostExecute(List<Eintrag> eintraege){
            super.onPostExecute(eintraege);
            eintragListAdapter.setEintraege(eintraege);
        }
    }

}

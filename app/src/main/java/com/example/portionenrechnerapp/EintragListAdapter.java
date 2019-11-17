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
    private EintragDao dao;

    private List<Eintrag> eintraege = Collections.emptyList();
    EintragListAdapter(EintragDao dao){
        this.dao = dao;
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

        loesche.setOnClickListener((view) -> {
            new DeleteEintragTask().execute(eintraege.get(position));
        });
    }

    @Override
    public int getItemCount() {
        return eintraege.size();
    }

    public void setEintraege(List<Eintrag> eintraege){
        this.eintraege = eintraege;
        notifyDataSetChanged();
    }

    public class EintragViewHolder extends RecyclerView.ViewHolder {

        public EintragViewHolder(@NonNull View itemView){
            super(itemView);
        }
    }

    class DeleteEintragTask extends AsyncTask<Eintrag, Void, List<Eintrag>>{

        @Override
        protected List<Eintrag> doInBackground(Eintrag... eintraege) {
            dao.delete(eintraege[0]);
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<Eintrag> eintraege){
            super.onPostExecute(eintraege);
            setEintraege(eintraege);
        }
    }

}

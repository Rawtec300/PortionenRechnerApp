package com.example.portionenrechnerapp;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class EintragListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Eintrag> eintraege = Collections.emptyList();
    private final EintragDao dao;
    public EintragListAdapter(EintragDao dao){
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
        TextView eintragView = holder.itemView.findViewById(R.id.list_item_eintrag);
        eintragView.setText(eintraege.get(position).getEintrag());

        eintragView.setOnClickListener((view) -> {
            new DeleteEintragTask(dao, this).execute(eintraege.get(position));
        });

        holder.itemView.setOnClickListener((view) -> {
            new DeleteEintragTask(dao, this).execute(eintraege.get(position));
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

    static class DeleteEintragTask extends AsyncTask<Eintrag, Void, List<Eintrag>> {

        private final EintragDao dao;
        private final EintragListAdapter adapter;

        public DeleteEintragTask(EintragDao dao, EintragListAdapter adapter) {
            this.dao = dao;
            this.adapter = adapter;
        }

        @Override
        protected List<Eintrag> doInBackground(Eintrag... eintraege) {
            dao.delete(eintraege[0]);
            return dao.getAll();
        }

        @Override
        protected void onPostExecute(List<Eintrag> words) {
            super.onPostExecute(words);
            adapter.setEintraege(words);
        }
    }

}

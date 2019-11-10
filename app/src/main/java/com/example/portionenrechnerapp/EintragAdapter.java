package com.example.portionenrechnerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class EintragAdapter extends RecyclerView.Adapter<EintragAdapter.ViewHolder> {

    ArrayList<String> eintraege;

    public EintragAdapter(ArrayList<String> eintraege) {
        this.eintraege = eintraege;
    }


    @Override
    public EintragAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eintrag_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EintragAdapter.ViewHolder holder, int position) {
        holder.verlaufGrammAlt.setText(eintraege.get(position));
    }

    @Override
    public int getItemCount() {
        return eintraege.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView verlaufGrammAlt;

        public ViewHolder(View itemView) {
            super(itemView);
            verlaufGrammAlt = itemView.findViewById(R.id.verlauf_gramm_alt);
        }
    }
}

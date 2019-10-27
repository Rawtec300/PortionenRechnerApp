package com.example.portionenrechnerapp;

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
    EintragListAdapter(){

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.activity_database_list, parent, false);
        return new EintragViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TextView eintragView = holder.itemView.findViewById(R.id.list_item_eintrag);
        eintragView.setText((CharSequence) eintraege.get(position).getEintrag());
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

}
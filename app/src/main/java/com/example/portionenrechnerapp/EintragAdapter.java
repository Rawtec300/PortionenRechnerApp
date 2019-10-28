package com.example.portionenrechnerapp;

import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

class EintragAdapter extends RecyclerView.Adapter<EintragAdapter.ViewHolder> {
    
    @Override
    public EintragAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(EintragAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}

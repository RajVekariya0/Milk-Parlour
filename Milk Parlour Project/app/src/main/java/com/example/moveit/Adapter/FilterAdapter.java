package com.example.moveit.Adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moveit.R;
import com.example.moveit.fragment.SeatFragment;
import com.example.moveit.model.Mysubitems;

import java.util.ArrayList;

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.CustomViewHolder> {

    private Mysubitems[] listdata;

    public FilterAdapter(Mysubitems[] listdata) {
        this.listdata = listdata;
    }

    @Override
    public FilterAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item_filter, parent, false);
        FilterAdapter.CustomViewHolder viewHolder = new FilterAdapter.CustomViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FilterAdapter.CustomViewHolder holder, int position) {
        final Mysubitems myListData = listdata[position];
        holder.tvOrigin.setText(listdata[position].getOrigin());
        holder.tvDestination.setText(listdata[position].getDestination());
        holder.tvBustime.setText(listdata[position].getBustime());
        holder.tvDate.setText(listdata[position].getDate());
        holder.tvHours.setText(listdata[position].getJournyhours());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                Fragment myFragment = new SeatFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, myFragment).addToBackStack(null).commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        public TextView tvOrigin;
        public TextView tvDestination;
        public TextView tvBustime;
        public TextView tvDate;
        public TextView tvHours;

        public CustomViewHolder(@NonNull View view) {
            super(view);
            tvOrigin = view.findViewById(R.id.tv_origion);
            tvDestination = view.findViewById(R.id.tv_destination);
            tvBustime = view.findViewById(R.id.tv_bustime);
            tvDate = view.findViewById(R.id.tv_date);
            tvHours = view.findViewById(R.id.tv_journyhours);
        }
    }
}
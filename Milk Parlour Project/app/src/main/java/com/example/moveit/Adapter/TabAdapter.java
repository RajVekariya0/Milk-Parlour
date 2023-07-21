package com.example.moveit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.moveit.R;
import com.example.moveit.model.MySeatData;


public class TabAdapter extends RecyclerView.Adapter<TabAdapter.CustomViewHolder> {
    private MySeatData[] mySeatData;
    private int selectedItem;
    Context context;

    public TabAdapter(MySeatData[] mySeatData, Context context) {
        this.mySeatData = mySeatData;
        this.context = context;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_seat, parent, false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        final MySeatData myListData = mySeatData[position];
        holder.ivSeat1.setImageResource(mySeatData[position].getImgId());
        holder.ivSeat2.setImageResource(mySeatData[position].getImgId());
        holder.ivSeat3.setImageResource(mySeatData[position].getImgId());
        holder.ivSeat4.setImageResource(mySeatData[position].getImgId());

        holder.ivSeat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ivSeat1.setImageDrawable(context.getResources().getDrawable(R.drawable.icn_select_seat));
            }
        });
        holder.ivSeat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ivSeat2.setImageDrawable(context.getResources().getDrawable(R.drawable.icn_select_seat));
            }
        });
        holder.ivSeat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ivSeat3.setImageDrawable(context.getResources().getDrawable(R.drawable.icn_select_seat));
            }
        });
        holder.ivSeat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.ivSeat4.setImageDrawable(context.getResources().getDrawable(R.drawable.icn_select_seat));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mySeatData.length;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSeat1;
        ImageView ivSeat2;
        ImageView ivSeat3;
        ImageView ivSeat4;

        public CustomViewHolder(View view) {
            super(view);
            ivSeat1 = (ImageView) view.findViewById(R.id.iv_seat1);
            ivSeat2 = (ImageView) view.findViewById(R.id.iv_seat2);
            ivSeat3 = (ImageView) view.findViewById(R.id.iv_seat3);
            ivSeat4 = (ImageView) view.findViewById(R.id.iv_seat4);
        }
    }
}
package com.example.moveit.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moveit.Adapter.TabAdapter;
import com.example.moveit.R;
import com.example.moveit.model.MySeatData;

public class SeatFragment extends Fragment {

    RecyclerView rvSeat;
    TextView tvDone;
    TabAdapter tabAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_seat, container, false);
        initViews(rootView);
        getData();
        return rootView;
    }

    private void initViews(View v) {
        rvSeat = v.findViewById(R.id.rv_left);
        tvDone = v.findViewById(R.id.tv_done);

        tvDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.dialog_confirmseat);
                TextView dialogButton = (TextView) dialog.findViewById(R.id.tv_dialog_done);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
    }

    private void getData() {
        MySeatData[] mySeatData = new MySeatData[]{
                new MySeatData(R.drawable.icn_seat),
                new MySeatData( R.drawable.icn_seat),
                new MySeatData( R.drawable.icn_seat),
                new MySeatData( R.drawable.icn_seat),
                new MySeatData( R.drawable.icn_seat),
                new MySeatData( R.drawable.icn_seat),
                new MySeatData( R.drawable.icn_seat),
        };

        tabAdapter = new TabAdapter(mySeatData,getActivity());
        rvSeat.setHasFixedSize(true);
        rvSeat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvSeat.setAdapter(tabAdapter);
    }
}

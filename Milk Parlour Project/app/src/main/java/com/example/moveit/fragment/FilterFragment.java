package com.example.moveit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moveit.Adapter.FilterAdapter;
import com.example.moveit.Adapter.TabAdapter;
import com.example.moveit.R;
import com.example.moveit.model.Mysubitems;

public class FilterFragment extends Fragment {

    RecyclerView rvFilter;
    TabAdapter tabAdapter;
    FilterAdapter filterAdapter;
    ImageView ivFilter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_filter, container, false);
        initViews(rootView);
        getFilter();
        return rootView;
    }

    private void initViews(View v) {
        rvFilter = v.findViewById(R.id.rv_filter);
        ivFilter = v.findViewById(R.id.iv_filter);

        ivFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSorting();
            }
        });
    }

    private void getFilter() {
        Mysubitems[] mysubitems = new Mysubitems[]{
                new Mysubitems("Paras Nagar","Hirawadi","11:00 PM","07/05/2021", "30 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","12:00 PM","07/05/2021", "40 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","10:00 PM","07/05/2021","35 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","11:30 PM","07/05/2021","25 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","10:30 PM","07/05/2021","50 minute"),
        };

        filterAdapter = new FilterAdapter(mysubitems);
        rvFilter.setHasFixedSize(true);
        rvFilter.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFilter.setAdapter(filterAdapter);
    }
    private void getSorting() {
        Mysubitems[] mysubitems = new Mysubitems[]{
                new Mysubitems("Paras Nagar","Hirawadi","10:00 PM","07/05/2021", "30 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","10:30 PM","07/05/2021", "40 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","11:00 PM","07/05/2021","35 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","11:30 PM","07/05/2021","25 minute"),
                new Mysubitems("Paras Nagar","Hirawadi","12:00 PM","07/05/2021","50 minute"),
        };

        filterAdapter = new FilterAdapter(mysubitems);
        rvFilter.setHasFixedSize(true);
        rvFilter.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvFilter.setAdapter(filterAdapter);
    }
}

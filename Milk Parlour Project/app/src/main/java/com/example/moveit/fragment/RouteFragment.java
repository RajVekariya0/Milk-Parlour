package com.example.moveit.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moveit.R;

import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class RouteFragment extends Fragment {

//    @BindView(R.id.spinner1)
//    Spinner spOrigion;
//
//    @BindView(R.id.spinner2)
//    Spinner SpinDestination;

    Spinner spOrigion;
    Spinner spDestination;
    ImageView ivOrigion;
    ImageView ivDestination;
    HorizontalCalendarView horizontalCalendar;

    TextView tvSearch;

    String[] origin = new String[]{
            "Paras Nagar",
            "Iskcon Cross Road BRTS",
            "I.S.R.O.", "Hirawadi",
            "Hanumanpura",
            "Kalupur railway station",
            "Dharnidhar Derasar",
            "Vaikunthdham Mandir",
            "Ramdev Nagar",
            "Bopal Gam BRTS Station",
            "Bopal Approach",
            "Shivranjani",
            "Science City Approach",
            "Shilaj",
            "Thaltej",
            "Bhuyangdev",
            "Chandola BRTS Workshop",
            "Ramdev Nagar Brts",
            "Ranip Cross Road",
            "Chandkheda BRTS Station",
            "Science City approach brts bus station"};


    public RouteFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        ButterKnife.bind(getActivity(), view);
        //getInit();
        initViews(view);
        return view;
    }

    private void initViews(View v) {

        spOrigion = (Spinner) v.findViewById(R.id.spinner1);
        spDestination = (Spinner) v.findViewById(R.id.spinner2);

        tvSearch = (TextView) v.findViewById(R.id.tv_search);

        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getActivity()
                        .getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, new FilterFragment());
                fragmentTransaction.commit();
            }
        });

        ivOrigion = (ImageView) v.findViewById(R.id.iv_spinner);
        ivDestination = (ImageView) v.findViewById(R.id.iv_spinner2);

        //horizontalCalendar = v.findViewById(R.id.calendarView);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.item_spinner, origin);

        spinnerArrayAdapter.setDropDownViewResource(R.layout.item_spinner);

        spOrigion.setAdapter(spinnerArrayAdapter);
        spDestination.setAdapter(spinnerArrayAdapter);

        spOrigion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ivOrigion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spOrigion.performClick();
            }
        });

        spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ivDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spDestination.performClick();
            }
        });

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(v, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
                Log.e("SELECTED_DATE",horizontalCalendar.getSelectedDate().toString());
            }
        });
    }

}
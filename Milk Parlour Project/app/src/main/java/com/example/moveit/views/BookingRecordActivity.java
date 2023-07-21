package com.example.moveit.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.moveit.Adapter.FilterAdapter;
import com.example.moveit.R;
import com.example.moveit.model.Mysubitems;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingRecordActivity extends AppCompatActivity {

    @BindView(R.id.tv_toolbarname)
    TextView tvToolbarname;

    RecyclerView rvBookingReord;

    FilterAdapter filterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_record);
        ButterKnife.bind(this);
        initViews();
        getBookingRecord();
    }
    private void initViews() {
        rvBookingReord = findViewById(R.id.rv_bookingrecord);
        tvToolbarname.setText("Booking Record");
    }
    private void getBookingRecord() {
        Mysubitems[] mysubitems = new Mysubitems[]{
                new Mysubitems("Paras Nagar","Hirawadi","11:00 PM","06/05/2021", "30 minute"),
                new Mysubitems("Hanumanpura","Shivranjani","12:00 PM","05/04/2021", "40 minute"),
                new Mysubitems("Shilaj","Thaltej","10:00 PM","04/03/2021","35 minute"),
                new Mysubitems("I.S.R.O.","Hirawadi","11:30 PM","27/02/2021","25 minute"),
                new Mysubitems("Bhuyangdev","Paras Nagar","10:30 PM","21/01/2021","50 minute"),
        };

        filterAdapter = new FilterAdapter(mysubitems);
        rvBookingReord.setHasFixedSize(true);
        rvBookingReord.setLayoutManager(new LinearLayoutManager(BookingRecordActivity.this));
        rvBookingReord.setAdapter(filterAdapter);
    }
}
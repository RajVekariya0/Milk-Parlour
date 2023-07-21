package com.example.moveit.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.moveit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TearmsconditionActivity extends AppCompatActivity {

    @BindView(R.id.tv_toolbarname)
    TextView tvToolbarname;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tearmscondition);
        ButterKnife.bind(this);
        initViews();
    }
    private void initViews() {
        tvToolbarname.setText("Tearms & Condition");
    }
}
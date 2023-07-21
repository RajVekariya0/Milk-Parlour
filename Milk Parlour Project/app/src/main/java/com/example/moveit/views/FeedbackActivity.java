package com.example.moveit.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moveit.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedbackActivity extends AppCompatActivity {

    @BindView(R.id.tv_toolbarname)
    TextView tvToolbarname;

    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        tvToolbarname.setText("FeedBack");
        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FeedbackActivity.this, "Feedback Submitted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
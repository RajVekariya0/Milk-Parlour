package com.example.moveit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.moveit.views.AboutUsActivity;
import com.example.moveit.views.BookingRecordActivity;
import com.example.moveit.views.ContactUsActivity;
import com.example.moveit.views.FeedbackActivity;
import com.example.moveit.views.LoginActivity;
import com.example.moveit.views.ProfileActivity;
import com.example.moveit.R;
import com.example.moveit.views.ChangePasswordActivity;
import com.example.moveit.views.TearmsconditionActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;

public class UserFragment extends Fragment {

    LinearLayout llChangepassword;
    LinearLayout llProfile;
    LinearLayout llFeedback;
    LinearLayout llContactUs;
    LinearLayout llAboutUs;
    LinearLayout llTearms;
    LinearLayout llLogout;
    LinearLayout llBookingRecord;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_user, container, false);
        initViews(rootView);
        return rootView;
    }

    private void initViews(View v) {
        llChangepassword = v.findViewById(R.id.ll_changepassword);
        llProfile = v.findViewById(R.id.ll_profile);
        llFeedback = v.findViewById(R.id.ll_feedback);
        llContactUs = v.findViewById(R.id.ll_contactus);
        llAboutUs = v.findViewById(R.id.ll_aboutus);
        llTearms = v.findViewById(R.id.ll_tearmsandconditions);
        llLogout = v.findViewById(R.id.ll_logout);
        llBookingRecord = v.findViewById(R.id.ll_bookingrecord);

        llBookingRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), BookingRecordActivity.class);
                getActivity().startActivity(intent);
            }
        });

        llLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i1 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(i1);
                                Toast.makeText(getActivity(), "Logout Successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        llChangepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChangePasswordActivity.class);
                getActivity().startActivity(intent);
            }
        });

        llProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                getActivity().startActivity(intent);
            }
        });

        llFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), FeedbackActivity.class);
                getActivity().startActivity(intent);
            }
        });

        llContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ContactUsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        llAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AboutUsActivity.class);
                getActivity().startActivity(intent);
            }
        });

        llTearms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), TearmsconditionActivity.class);
                getActivity().startActivity(intent);
            }
        });
    }
}
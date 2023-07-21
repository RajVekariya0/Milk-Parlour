package com.example.moveit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moveit.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Forgot_PasswordActivity extends AppCompatActivity {
    private static final String TAG = "Forgot_PasswordActivity";
    @BindView(R.id.edEmail)
    EditText edEmail;
    @BindView(R.id.btnResetPassword)
    TextView btn_ResetPassword;
    @BindView(R.id.txtBack)
    TextView txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);
        ButterKnife.bind(this);
        getInit();
    }

    private void getInit() {
        btn_ResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Forgot_PasswordActivity.this, "Email Sent", Toast.LENGTH_SHORT).show();

                String email = edEmail.getText().toString();
                if (TextUtils.isEmpty(email)){
                    Toast.makeText(Forgot_PasswordActivity.this, "Please Enter valid Email address", Toast.LENGTH_SHORT).show();
                } else {
                    FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(Forgot_PasswordActivity.this, "Mail sent on " + email, Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });


//        btn_ResetPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Forgot_PasswordActivity.this, "Email Sent", Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}
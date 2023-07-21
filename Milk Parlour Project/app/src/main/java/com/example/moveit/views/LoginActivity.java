package com.example.moveit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moveit.R;
import com.example.moveit.utils.AppUtils;
import com.example.moveit.utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.edEmail)
    EditText edEmail;
    @BindView(R.id.edPassword)
    EditText edPassword;
    @BindView(R.id.btnLogin)
    TextView btnLogin;
    @BindView(R.id.txtForgot_password)
    TextView txtForgot_password;
    @BindView(R.id.txtSignup)
    TextView txtSignup;

    FirebaseAuth firebaseAuth;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        boolean isLogin = AppUtils.getValue(this,Constants.isLogin);
        if (isLogin){
            startActivity(new Intent(LoginActivity.this, RouteActivity.class));
            finish();
        }

        firebaseAuth = FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString().trim();
                String password = edPassword.getText().toString().trim();

//                Intent intent = new Intent(LoginActivity.this,RouteActivity.class);
//                startActivity(intent);

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                String userId = task.getResult().getUser().getUid();
                                AppUtils.setStringValue(LoginActivity.this, Constants.USER_ID, userId);
                                AppUtils.setStringValue(LoginActivity.this, Constants.email,email);
                                AppUtils.setStringValue(LoginActivity.this, Constants.password, password);
                                startActivity(new Intent(LoginActivity.this, RouteActivity.class));
                                AppUtils.setValue(LoginActivity.this,Constants.isLogin,true);
                            } else {
                                Toast.makeText(LoginActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

        txtForgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, Forgot_PasswordActivity.class);
                startActivity(intent);
            }
        });

        txtSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
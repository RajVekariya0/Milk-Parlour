package com.example.moveit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moveit.R;
import com.example.moveit.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegistrationActivity extends AppCompatActivity {

    @BindView(R.id.edName)
    EditText edName;
    @BindView(R.id.edPhone)
    EditText edPhone;
    @BindView(R.id.edEmail)
    EditText edEmail;
    @BindView(R.id.edPassword)
    EditText edPassword;
    @BindView(R.id.edReenter_passwprd)
    EditText edReenter_passwprd;
    @BindView(R.id.chbcondition)
    CheckBox chbcondition;
    @BindView(R.id.btnSignup)
    TextView btnSignup;

    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
        getInit();
    }

    private void getInit() {
        firebaseAuth = FirebaseAuth.getInstance();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();
                String email = edEmail.getText().toString();
                String mobile = edPhone.getText().toString();
                String password = edPassword.getText().toString();
                String rePassword = edReenter_passwprd.getText().toString();

//                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
//                startActivity(intent);

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(RegistrationActivity.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegistrationActivity.this, "Please Enter Email address", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(mobile)) {
                    Toast.makeText(RegistrationActivity.this, "Please Enter Valid Mobile Number", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegistrationActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(rePassword)) {
                    Toast.makeText(RegistrationActivity.this, "Please Re Enter Password", Toast.LENGTH_SHORT).show();
                } else {

                    String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{4,}$";

                    if (!password.matches(pattern)) {
                        Toast.makeText(RegistrationActivity.this, "Please Enter Strong password", Toast.LENGTH_SHORT).show();
                    } else {
                        if (password.equals(rePassword)) {
                            //TODO Register

                            if (!chbcondition.isChecked()) {
                                Toast.makeText(RegistrationActivity.this, "Agree our Terms & conditions", Toast.LENGTH_SHORT).show();
                            } else {


                                firebaseAuth.createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                            @Override
                                            public void onComplete(@NonNull Task<AuthResult> task) {
                                                if (task.isSuccessful()) {
                                                    String userId = task.getResult().getUser().getUid();
                                                    databaseReference = firebaseDatabase.getReference("Users");
                                                    User user = new User();
                                                    user.setU_name(name);
                                                    user.setU_email(email);
                                                    user.setU_id(userId);
                                                    user.setU_phone(mobile);
                                                    user.setU_password(password);
                                                    databaseReference.child(userId).setValue(user);
                                                    Toast.makeText(RegistrationActivity.this, "User Registered", Toast.LENGTH_SHORT).show();
                                                    Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                                                    startActivity(intent);
                                                }

                                            }
                                        });
                            }
                        } else {
                            Toast.makeText(RegistrationActivity.this, "Password Does not match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}
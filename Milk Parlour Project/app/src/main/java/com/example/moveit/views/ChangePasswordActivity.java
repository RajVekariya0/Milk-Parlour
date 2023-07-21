package com.example.moveit.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moveit.R;
import com.example.moveit.utils.AppUtils;
import com.example.moveit.utils.Constants;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.moveit.utils.Constants.email;
import static com.example.moveit.utils.Constants.password;

public class ChangePasswordActivity extends AppCompatActivity {

    @BindView(R.id.edPassword)
    EditText edPassword;
    @BindView(R.id.edNewPassword)
    EditText edNewPassword;
    @BindView(R.id.edConfirmPassword)
    EditText edConfirmPassword;
    @BindView(R.id.btnChangePassword)
    TextView btnChangePassword;
    @BindView(R.id.tv_toolbarname)
    TextView tvToolbarname;

    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference;

    private static final String TAG = "ChangePasswordActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ButterKnife.bind(this);
        initViews();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
        String email = AppUtils.getStringValue(this, Constants.email);
        String password = AppUtils.getStringValue(this, Constants.password);
//        AuthCredential credential = EmailAuthProvider.getCredential(email, password);

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait");
        dialog.setTitle("Changing password");


// Prompt the user to re-provide their sign-in credentials
        //commit
//        btnChangePassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String password = edPassword.getText().toString();
//                String newpassword=edNewPassword.getText().toString();
//                String repassword=edConfirmPassword.getText().toString();
//
//                if (TextUtils.isEmpty(password)) {
//                    Toast.makeText(ChangePasswordActivity.this, "Please Enter Current Password", Toast.LENGTH_SHORT).show();
//                } else if (TextUtils.isEmpty(newpassword)) {
//                    Toast.makeText(ChangePasswordActivity.this, "Please Enter New Password", Toast.LENGTH_SHORT).show();
//                } else if (TextUtils.isEmpty(repassword)) {
//                    Toast.makeText(ChangePasswordActivity.this, "Please Re Enter New Password", Toast.LENGTH_SHORT).show();
//                }else   {
//                    String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_])(?=\\S+$).{4,}$";
//
//                    if (!newpassword.matches(pattern)) {
//                        Toast.makeText(ChangePasswordActivity.this, "Please Enter Strong password", Toast.LENGTH_SHORT).show();
//                    }else{
//                        if(!newpassword.equals(repassword)){
//                            Toast.makeText(ChangePasswordActivity.this, "Password doesn't match with New Password", Toast.LENGTH_SHORT).show();
//                        }else{
//                            dialog.show();
//                            user.reauthenticate(credential)
//                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
//                                        @Override
//                                        public void onComplete(@NonNull Task<Void> task) {
//                                            if (task.isSuccessful()) {
//                                                user.updatePassword(newpassword).addOnCompleteListener(new OnCompleteListener<Void>() {
//                                                    @Override
//                                                    public void onComplete(@NonNull Task<Void> task) {
//                                                        dialog.dismiss();
//                                                       // AppUtils.setStringValue(ChangePasswordActivity.this, email,email);
//
//                                                        //AppUtils.setValue(ChangePasswordActivity.this,Constants.password,true);
//                                                        if (task.isSuccessful()) {
//                                                            AppUtils.setStringValue(ChangePasswordActivity.this, password, password);
//                                                            Toast.makeText(ChangePasswordActivity.this, "Password changed", Toast.LENGTH_SHORT).show();
//                                                            Log.d(TAG, "Password updated");
//                                                            databaseReference = firebaseDatabase.getReference("Users");
//                                                            String userId = AppUtils.getStringValue(ChangePasswordActivity.this,Constants.USER_ID);
//                                                            databaseReference.child(userId).child("u_password").setValue(newpassword);
//                                                            startActivity(new Intent(ChangePasswordActivity.this, RouteActivity.class));
//                                                        } else {
//                                                            Toast.makeText(ChangePasswordActivity.this, "Something went wrong! Please try again", Toast.LENGTH_SHORT).show();
//                                                            Log.d(TAG, "Error password not updated");
//                                                            dialog.dismiss();
//                                                        }
//                                                    }
//                                                });
//                                            } else {
//                                                Log.d(TAG, "Error auth failed");
//                                            }
//                                        }
//                                    });
//                        }
//                    }
//                }
//            }
//        });
    }

    private void initViews() {
        tvToolbarname.setText("Change Password");
    }
}
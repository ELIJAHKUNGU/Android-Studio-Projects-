package com.vibration.homedoctor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.vibration.homedoctor.activities.models.CategoriesActivity;

public class LoginActivity extends AppCompatActivity {
    EditText Emailaddress, mPassword;
    Button mButtonLogin;
    ProgressDialog progressDialog;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressDialog  = new ProgressDialog(this);
        progressDialog.setMessage("Loading \nPlease Wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        Emailaddress = (EditText) findViewById(R.id.etEmail);
        mPassword = (EditText) findViewById(R.id.etPass);
        mButtonLogin = (Button) findViewById(R.id.btnlogin);
        mAuth=FirebaseAuth.getInstance();
       Validate();


    }

    private boolean Validate() {
       boolean results=false;
        String getmEmail = Emailaddress.getText().toString();
        String getmPassword = mPassword.getText().toString();


        if (getmEmail.isEmpty()) {
            
            Toast.makeText(this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
        } else if (getmPassword.isEmpty()) {
            Toast.makeText(this, "Please Enter your Password", Toast.LENGTH_SHORT).show();
        } else {
            results = true;
        }
        return results;
    }





    public void createHosipital(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
    }
    public void loginUser(View view) {


        if (Validate()) {
            String email = Emailaddress.getText().toString().trim();
            String password = mPassword.getText().toString().trim();
            progressDialog.show();


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        progressDialog.dismiss();

                                        startActivity(new Intent(LoginActivity.this, CategoriesActivity.class));
                                        Toast.makeText(LoginActivity.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                                    }else{
                                        progressDialog.dismiss();
                                        Toast.makeText(LoginActivity.this, "login not successful", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                    );
        }
    }


       }



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
import com.google.firebase.auth.FirebaseUser;
import com.vibration.homedoctor.activities.models.CategoriesActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText musername, mpassword, memail, mconfirmpassword;
    Button login;
    ProgressDialog progressDialog;
/*
    ProgressBar progressBar;
*/

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressDialog  = new ProgressDialog(this);
        progressDialog.setMessage("Registering\nPlease Wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        findview();
    }



    private boolean Validate() {

        boolean result = false;
        String getuser = musername.getText().toString();
        String getemail = memail.getText().toString();
        String getpassword = mpassword.getText().toString();
        String getconfirmpassword = mconfirmpassword.getText().toString();

        if (getuser.isEmpty()) {
            Toast.makeText(this, "Please fill your Username", Toast.LENGTH_SHORT).show();
        } else if (getemail.isEmpty()) {
            Toast.makeText(this, "Please fill your Email", Toast.LENGTH_SHORT).show();
        } else if (getpassword.isEmpty()) {
            Toast.makeText(this, "Please fill your Password", Toast.LENGTH_SHORT).show();
        } else if (getconfirmpassword.isEmpty()) {
            Toast.makeText(this, "Please fill your Confirm Password", Toast.LENGTH_SHORT).show();
        } else {
            result = true;
        }
        return result;
    }

    private void findview() {
        musername = (EditText) findViewById(R.id.etUsername);
        memail = (EditText) findViewById(R.id.etUserEmail);
        mpassword = (EditText) findViewById(R.id.etPass);
        mconfirmpassword = (EditText) findViewById(R.id.etConfirmPass);
        login = (Button) findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();

 /*    progressBar=(ProgressBar) findViewById(R.id.progressBar);*/
    }


    public void login(View view) {
        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
    }

    public void Register(View view) {
        if (Validate()) {
            String reg_email = memail.getText().toString().trim();
            String reg_passwword = mpassword.getText().toString().trim();
            progressDialog.show();
            mAuth.createUserWithEmailAndPassword(reg_email, reg_passwword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                progressDialog.dismiss();
                                Toast.makeText(RegisterActivity.this, "Registrational was successful", Toast.LENGTH_SHORT).show();
                               /* progressBar.setVisibility(View.GONE);*/
                                sendEmailVerification();
                                startActivity(new Intent(RegisterActivity.this, CategoriesActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registrational not successful", Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss();
                            }
                        }
                    });

        }
    }
    private void sendEmailVerification(){
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null){
            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registered Successfully. Verification mail has been sent to "+memail.getText().toString(), Toast.LENGTH_SHORT).show();
                        mAuth.signOut();
                        finish();

                    }else {
                        Toast.makeText(RegisterActivity.this, "Registration Failed. Please try again. \n Verification mail not sent", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    }


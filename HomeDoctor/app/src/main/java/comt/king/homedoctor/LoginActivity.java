package comt.king.homedoctor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {
    EditText mEmailaddress, mPassword;
    Button mButtonLogin;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmailaddress = (EditText) findViewById(R.id.etUserEmail);
        mPassword = (EditText) findViewById(R.id.etPass);
        mButtonLogin = (Button) findViewById(R.id.btnRegister);
        mAuth = FirebaseAuth.getInstance();
        validate();
    }

    private boolean validate() {
        boolean results=false;
        String getmEmail=mEmailaddress.getText().toString();
        String getmpass=mPassword.getText().toString();


        if (getmEmail.isEmpty()){
            Toast.makeText(this, "Please Enter your Email", Toast.LENGTH_SHORT).show();
        }else if (getmpass.isEmpty()){
            Toast.makeText(this, "Please Enter your Password", Toast.LENGTH_SHORT).show();
        }else {
            results=true;
        }
        return results;
    }
    public void loginUser(){
        if (validate()) {
            String email = mEmailaddress.getText().toString().trim();
            String password = mPassword.getText().toString().trim();


            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        startActivity(new Intent(LoginActivity.this, PatientActivity.class));
                                        Toast.makeText(LoginActivity.this, "logged in successfully", Toast.LENGTH_SHORT).show();
                                        Toast.makeText(LoginActivity.this, "Logged in failed", Toast.LENGTH_SHORT).show();

                                    }
                                }
                            }
                    );
        }

    }


    public void createaccount(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
    }
}
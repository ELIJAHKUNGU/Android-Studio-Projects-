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

public class RegisterActivity extends AppCompatActivity {
    EditText  musername,mpassword,memail,mconfirmpassword;
    Button login;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findview();
        Validate();
    }

    private boolean Validate() {
        boolean result = false;
        String getname = musername.getText().toString();
        String getemail = memail.getText().toString();
        String getpassword = mpassword.getText().toString();
        String getconfirmpassword =mconfirmpassword.getText().toString();
        if (getname.isEmpty()){
            Toast.makeText(this, "Please fill your Username", Toast.LENGTH_SHORT).show();
        }else if (getemail.isEmpty()){
            Toast.makeText(this, "Please fill your Email", Toast.LENGTH_SHORT).show();
        }else if (getpassword.isEmpty()){
            Toast.makeText(this, "Please fill your Password", Toast.LENGTH_SHORT).show();
        }else if (getconfirmpassword.isEmpty()){
            Toast.makeText(this, "Please fill your Confirm Password", Toast.LENGTH_SHORT).show();
        }else{
            result= true;
        }return result;
    }

    private void findview() {
        musername=(EditText)findViewById(R.id.etUsername);
        memail=(EditText)findViewById(R.id.etUserEmail);
        mpassword=(EditText)findViewById(R.id.etPass);
        mconfirmpassword=(EditText)findViewById(R.id.etConfirmPass);
        login=(Button) findViewById(R.id.btnRegister);
        /* progressBar=(progressBar) findViewById(R.id.)*/
    }

    public void Registeruser(){
        if (Validate()){
            String reg_email=memail.getText().toString().trim();
            String reg_passwword=mpassword.getText().toString().trim();
            /* progressBar.setVisibility(View.VISIBLE);*/
            mAuth.createUserWithEmailAndPassword(reg_email,reg_passwword)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(RegisterActivity.this, "Registrational was successful", Toast.LENGTH_SHORT).show();
                                /*  progressBar.setVisibility(View.GONE);*/
                                startActivity(new Intent(RegisterActivity.this,PatientActivity.class));
                            }else {
                                Toast.makeText(RegisterActivity.this, "Registrational not successful", Toast.LENGTH_SHORT).show();
                                /*progressBar.setVisibility(View.GONE);*/
                            }
                        }
                    });

        }

    }


    public void login(View view) {
        startActivity(new Intent(RegisterActivity.this,PatientActivity.class));
    }
}

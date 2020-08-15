package com.vibration.homedoctor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AddActivtiy extends AppCompatActivity  {

    Button Asubmit;
    EditText Mainservice,ServiceOne,Servicetwo,Servicethree,MoreDetails;
    DatabaseReference databaseReference;
    ProgressDialog progressDialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_activtiy);
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();
        progressDialog  = new ProgressDialog(this);
        progressDialog.setMessage("Loading\nPlease Wait...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        databaseReference= FirebaseDatabase.getInstance().getReference("Services");


        Asubmit=(Button)findViewById(R.id.aSubmit);
        Mainservice=(EditText)findViewById(R.id.MainService);
        ServiceOne=(EditText)findViewById(R.id.ServiceOne);
        Servicetwo=(EditText)findViewById(R.id.ServiceTwo);
        Servicethree=(EditText)findViewById(R.id.ServiceThree);
        MoreDetails=(EditText)findViewById(R.id.MoreDetails);



        Asubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddService();



            }
        });
    }
    public  void AddService(){


        String mainservice= Mainservice.getText().toString().trim();
        String serviceone= ServiceOne.getText().toString().trim();
        String servicetwo= Servicetwo.getText().toString().trim();
        String servicethree= Servicethree.getText().toString().trim();
        String moredeatils=MoreDetails.getText().toString().trim();
        String Id= databaseReference.push().getKey();



        if (mainservice.isEmpty()){
            Toast.makeText(this, "Enter the Main AddService", Toast.LENGTH_SHORT).show();
        }else if (serviceone.isEmpty()){
            Toast.makeText(this, "Enter the Sub_Service one", Toast.LENGTH_SHORT).show();
        }else if (servicetwo.isEmpty()) {
            Toast.makeText(this, "Enter the Sub_Service two", Toast.LENGTH_SHORT).show();

        }else if (servicethree.isEmpty()) {
            Toast.makeText(this, "Enter the Sub_Service three,if no more service write that", Toast.LENGTH_SHORT).show();
        }else if (moredeatils.isEmpty()) {
            Toast.makeText(this, "Tells us when the service are offered,by who ,what should the procedure", Toast.LENGTH_SHORT).show();
        }else{
            progressDialog.show();

            AddService addService=new AddService(mainservice,Id,serviceone,servicetwo,servicethree,moredeatils);
            databaseReference.child(Id).setValue(addService).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        progressDialog.dismiss();

                        Toast.makeText(AddActivtiy.this, "Services added successfully", Toast.LENGTH_SHORT).show();
                        check();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(AddActivtiy.this, "Opsss something went wrong", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }








    }


    public void ClearPage(View view) {
        Mainservice.setText("");
        ServiceOne.setText("");
        Servicetwo.setText("");
        Servicethree.setText("");


    }
    public void  check() {
        startActivity(new Intent(AddActivtiy.this, HospitalActivity.class));


    }


}

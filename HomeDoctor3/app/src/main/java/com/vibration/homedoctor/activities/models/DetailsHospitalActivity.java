package com.vibration.homedoctor.activities.models;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.vibration.homedoctor.FileHelper;
import com.vibration.homedoctor.Hospital_Profile;
import com.vibration.homedoctor.R;

public class DetailsHospitalActivity extends AppCompatActivity  {

    DatabaseReference databaseReference;


    public Uri imguri;
    private static final int IMAGE_PICK_CODE=1000;
    private static final int PERMISSION_CODE=1000;
    private static final String TAG = "DetailsHospitalActivity";


    EditText username, hemail, hphoneNo, hlocation, hmore;
    Button  submit;
    ImageView imageVi;
    private StorageReference mStorageRef;
    Hospital_Profile profiles;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_hospital);
        Window w =getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getSupportActionBar().hide();
        databaseReference= FirebaseDatabase.getInstance().getReference("Details");
        mStorageRef = FirebaseStorage.getInstance().getReference("Images");


        username = (EditText) findViewById(R.id.UserName);
        hemail = (EditText) findViewById(R.id.etEmail);
        hphoneNo = (EditText) findViewById(R.id.etPhone);
        hlocation = (EditText) findViewById(R.id.etLocation);
        hmore = (EditText) findViewById(R.id.etMoreDetails);
        imageVi=(ImageView)findViewById(R.id.IMAGE);
        profiles=new Hospital_Profile();

        submit = (Button) findViewById(R.id.Submit);


    }


    private void uploadFile() {
       profiles.setUser(username.getText().toString().trim());
        profiles.setEmail(hemail.getText().toString().trim());
        profiles.setLocation(hlocation.getText().toString().trim());
        profiles.setPhoneNo(hphoneNo.getText().toString().trim());
        profiles.setMore(hmore.getText().toString().trim());
        if (imguri==null){
            Toast.makeText(this, "upload a photo", Toast.LENGTH_SHORT).show();
        }else {


            byte[] fileByte = FileHelper.getByteArrayFromFile(DetailsHospitalActivity.this, imguri);
            String encodedImage = Base64.encodeToString(fileByte, Base64.NO_WRAP);
            profiles.setImage(encodedImage);

            databaseReference.push().setValue(profiles).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    Toast.makeText(DetailsHospitalActivity.this, "Service added successfully", Toast.LENGTH_SHORT).show();

                }
            });


        }

    }





        public void Exsting (View view){
       }

    public void SUBMIT(View view) {
        uploadFile();
        Validate();
    }

    public void Uploads(View view) {

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(resultCode==RESULT_OK && requestCode==IMAGE_PICK_CODE){
            imageVi.setImageURI(data.getData());
        }
        if(requestCode==1 && resultCode==RESULT_OK && data!=null && data.getData()!=null){
            imguri=data.getData();
         /*  imageView.setImageURI(imguri);*/
            imageVi.setImageURI(imguri);
        }
    }
    public boolean Validate(){
        boolean result=false;
        String user= username.getText().toString().trim();
        String email= hemail.getText().toString().trim();
        /*tring image=imageView.toString();*/

        String phonenumber= hphoneNo.getText().toString().trim();
        String location=hlocation.getText().toString().trim();
        String moreDetails=hmore.getText().toString().trim();


        if (user.isEmpty()){
            Toast.makeText(this, "Enter username", Toast.LENGTH_SHORT).show();
        }else if (email.isEmpty()){
            Toast.makeText(this, "Enter the email", Toast.LENGTH_SHORT).show();
        }else if (phonenumber.isEmpty()) {
            Toast.makeText(this, "phone number", Toast.LENGTH_SHORT).show();

        }else if (location.isEmpty()) {
            Toast.makeText(this, "Enter the location", Toast.LENGTH_SHORT).show();
        }else if (moreDetails.isEmpty()) {
            Toast.makeText(this, "Add some details", Toast.LENGTH_SHORT).show();
        }else {
            result =true;
        }
        return result;

    }

}

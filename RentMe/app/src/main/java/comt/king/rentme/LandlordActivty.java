package comt.king.rentme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LandlordActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_activty);
    }

    public void Register(View view) {
        startActivity(new Intent(LandlordActivty.this, RegisterAccount.class));


    }

    public void LoginAccount(View view) {
        startActivity(new Intent(LandlordActivty.this, LoginAccount.class));


    }
}

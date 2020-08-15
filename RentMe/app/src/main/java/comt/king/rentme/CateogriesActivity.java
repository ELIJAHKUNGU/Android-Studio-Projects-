package comt.king.rentme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CateogriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cateogries);
    }

    public void Account(View view) {
        startActivity(new Intent(CateogriesActivity.this, LandlordActivty.class));
    }

    public void slideshow(View view) {
        startActivity(new Intent(CateogriesActivity.this, SlidesActivity.class));

    }

    public void slides(View view) {
        startActivity(new Intent(CateogriesActivity.this, SlidesActivity.class));


    }

    public void learnmore(View view) {
        startActivity(new Intent(CateogriesActivity.this, LearnmoreActivity.class));


    }
}

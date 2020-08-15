package com.king.movieapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsMovieActivity extends AppCompatActivity {
    //declare var
    ImageView mImagePoster;
    TextView mTittle, mMovieYear, mMovieDescription;

    //in in array poster array
    int[] images= {
            R.drawable.dem,R.drawable.fall,R.drawable.fam, R.drawable.fear, R.drawable.ghost,
            R.drawable.iron, R.drawable.kill, R.drawable.wolf, R.drawable.woman,
    };
    // movie tittles
    String[] movieTitles = {"avengers","riverdale","End Game","The Brave","TeenWolf","Avater","Shadow","the Unit",
            "Tommorow People","Baby Driver","jungle Book","Don 2","Originals","Legacies","Elites","The Last Og"};


    // movie year release
    String[] movieRelYear = {"2010","2016","2019","2018","2012","2010","2019","2012",
            "2014","2017","2009","2015","2014","2019","2019","2018"};

    //array of movie decription
    String[] movieDescription = {
            "this fiction is about the greatest super heroes the world has ever had. this is a must watch",
            "this is a story os small miserable town",
            "this if you are fun of the avengers well watch tis season finale movie of the avengers as they end their domination",
            "this movie movie is al about five intellgent soldirs who fight terrorism defending their country",
            "this is supernatural movie a must watch buda hii move ni ngori ata mimi nishai ii watch",
            "Hii movie ni kitambo bana lakini ni kali mzae unafaa u buy uende upatie watoi wako waone ",
            "well africans a rising, this is an action movie from south africa, action of course, hrer you will find the african superhero",
            "boom this another anti crime terrorism series mast watch",
            "super natural movie funs here is your catch . this species of human being are being hunted down watch as they fight to protect their existence",
            "all about bank roberies",
            "this fiction is about the greatest super heroes the world has ever had. this is a must watch",
            "this fiction is about the greatest super heroes the world has ever had. this is a must watch",
            "this fiction is about the greatest super heroes the world has ever had. this is a must watch"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_movie);

        //assign views to var
        mImagePoster = findViewById(R.id.imageTed);
        mTittle = findViewById(R.id.textTitle);
        mMovieYear = findViewById(R.id.textyear);
        mMovieDescription = findViewById(R.id.textDetails);

       //receive intent
         Intent receive = getIntent();

         int pos = receive.getIntExtra("pos", 0);

         mImagePoster.setImageResource(images[pos]);
         mTittle.setText(movieTitles[pos]);
         mMovieYear.setText(movieRelYear[pos]);
         mMovieDescription.setText(movieDescription[pos]);


    }
}

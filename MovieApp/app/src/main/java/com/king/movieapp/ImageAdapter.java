package com.king.movieapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.king.movieapp.R;

public class ImageAdapter extends BaseAdapter {
    Context mContext;
    public ImageAdapter(Context context){
        this.mContext = context;
    }
    int[] images= {
            R.drawable.dem,R.drawable.fall,R.drawable.fam, R.drawable.fear, R.drawable.ghost,
            R.drawable.iron, R.drawable.kill, R.drawable.wolf, R.drawable.woman,
    };




    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imagepic = new ImageView(mContext);
        imagepic.setImageResource(images[position]);
        imagepic.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imagepic.setAdjustViewBounds(true);
        return imagepic;
    }
}
//oyamobrian8
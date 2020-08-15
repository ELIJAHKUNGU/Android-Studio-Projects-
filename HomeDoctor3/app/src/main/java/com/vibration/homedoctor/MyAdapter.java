package com.vibration.homedoctor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MYADAPTER extends RecyclerView.Adapter{

        Context context;
    ArrayList<Profile> lists;

    public MYADAPTER(Context c , ArrayList<Profile> p)
    {
        context = c;
     lists= p;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.cardview,parent,false);
        MyViewholder holder=new MyViewholder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewholder) holder).bindData(position);
        ((MyViewholder) holder).name.setText(lists.get(position).getUser());
        ((MyViewholder) holder).email.setText(lists.get(position).getEmail());
        ((MyViewholder) holder).phonenumber.setText(lists.get(position).getPhoneNo());
        ((MyViewholder) holder).location.setText(lists.get(position).getLocation());
        ((MyViewholder) holder).more_details.setText(lists.get(position).getMore_details());


        if(lists.get(position).getImage() != null) {
            byte[] decodedString = Base64.decode(lists.get(position).getImage(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ((MyViewholder) holder).Image.setImageBitmap(decodedByte);
        }

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

   /* @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(lists.get(position).getUser());
        holder.email.setText(lists.get(position).getEmail());
        holder.phonenumber.setText(lists.get(position).getPhoneNo());
        holder.location.setText(lists.get(position).getLocation());
        holder.more_details.setText(lists.get(position).getMore_details());


        byte[] decodedString= Base64.decode(lists.get(position).getImage(),Base64.DEFAULT);
        Bitmap decodedByte= BitmapFactory.decodeByteArray(decodedString,0,decodedString.length);
       holder.image.setImageBitmap(decodedByte);





    }

    @Override
    public int getItemCount() {
        return lists.size();
    }*/

    class MyViewholder extends RecyclerView.ViewHolder
    {
        TextView name,email,phonenumber,location,more_details;
        ImageView Image;
        RatingBar rating;


        public MyViewholder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
           location = (TextView) itemView.findViewById(R.id.location);
          more_details= (TextView) itemView.findViewById(R.id.more_details);
           phonenumber = (TextView) itemView.findViewById(R.id.phonenumber);
           rating=(RatingBar) itemView.findViewById(R.id.ratingBar2);

        Image=(ImageView) itemView.findViewById(R.id.myImageS);




        }
        void  bindData(int position){

        }

    }
}
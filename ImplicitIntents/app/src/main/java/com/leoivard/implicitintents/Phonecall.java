package com.leoivard.implicitintents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public  class Phonecall extends Fragment {
    EditText mPhoneNo;
    EditText mTextToSend;
    Button mCallBtn;
    Button  mTextBtn;

    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    public Phonecall() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static MainActivity.PlaceholderFragment newInstance(int sectionNumber) {
        MainActivity.PlaceholderFragment fragment = new MainActivity.PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_phonecall, container, false);
        //assign variables
        mPhoneNo = rootView.findViewById(R.id.editText);
        mTextToSend =rootView.findViewById(R.id.edtSms);
        mCallBtn = rootView.findViewById(R.id.btnCall);
        mTextBtn  = rootView.findViewById(R.id.btnSms);
        //set click handler on click btn
        mCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //grab phone. from user input
                String phone =mPhoneNo.getText().toString();
                //create a uri object
                Uri uri = Uri.fromParts("tel",phone,null);
                //dial intent
                Intent dial =new Intent(Intent.ACTION_DIAL,uri);
                startActivity(dial);
                )
            }
        });
mSmsBtn.SetOnclickListener(new View.OnClickListener() {
    @Override
    public

}
        return rootView;
    }
}


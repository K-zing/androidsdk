package com.kzingsdk.kzingsdktest;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

public class ParcelableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        ArrayList<Parcelable> pList = getIntent().getParcelableArrayListExtra("test");
        for (Parcelable p : pList) {
            Log.d("ParcelableActivity", p.toString());
        }

    }
}
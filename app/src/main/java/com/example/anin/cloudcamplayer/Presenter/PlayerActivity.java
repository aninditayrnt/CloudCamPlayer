package com.example.anin.cloudcamplayer.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.anin.cloudcamplayer.R;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent i = getIntent();
        String sourceID = i.getStringExtra("sourceID");
        String sourceToken = i.getStringExtra("sourceToken");

        Log.i("bbken", sourceID);
        Log.i("bbken", sourceToken);
    }
}

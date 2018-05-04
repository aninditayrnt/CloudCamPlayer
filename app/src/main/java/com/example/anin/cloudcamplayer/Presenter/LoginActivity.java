package com.example.anin.cloudcamplayer.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anin.cloudcamplayer.R;

public class LoginActivity extends AppCompatActivity{

    Button startButton;
    EditText sourceID, sourceToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startButton = (Button) findViewById(R.id.startStreamButton);
        sourceID = (EditText) findViewById(R.id.tokenID);
        sourceToken = (EditText) findViewById(R.id.tokenAccess);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, PlayerActivity.class);
                i.putExtra("sourceID", sourceID.getText().toString());
                i.putExtra("sourceToken", sourceToken.getText().toString());
                startActivity(i);
            }
        });
    }
}
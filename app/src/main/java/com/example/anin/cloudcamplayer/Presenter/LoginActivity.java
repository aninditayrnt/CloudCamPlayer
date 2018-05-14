package com.example.anin.cloudcamplayer.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anin.cloudcamplayer.Model.TokenRefreshResponse;
import com.example.anin.cloudcamplayer.R;
import com.example.anin.cloudcamplayer.Rest.APIClient;
import com.example.anin.cloudcamplayer.Rest.APIInterface;
import com.example.anin.cloudcamplayer.Service.SocketService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity{

    Button startButton;
    EditText sourceID, sourceToken, refreshToken, baseToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        startButton = (Button) findViewById(R.id.startStreamButton);
        sourceID = (EditText) findViewById(R.id.tokenID);
        sourceToken = (EditText) findViewById(R.id.tokenAccess);
        refreshToken = (EditText) findViewById(R.id.refreshToken);
        baseToken =  (EditText) findViewById(R.id.baseToken);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIInterface service = APIClient.getClient().create(APIInterface.class);

                Call<TokenRefreshResponse> call = service.login("Bearer " + sourceToken.getText().toString(), refreshToken.getText().toString());
                call.enqueue(new Callback<TokenRefreshResponse>() {
                    @Override
                    public void onResponse(Call<TokenRefreshResponse> call, Response<TokenRefreshResponse> response) {
                        Log.d("bbken", response.body().getEntityID());
                        Log.d("bbken", response.body().getRefreshToken());
                        Log.d("bbken", response.body().getAccessToken());
                        String entityID = response.body().getEntityID();
                        String refToken = response.body().getRefreshToken();
                        String token = response.body().getAccessToken();

                        Intent i = new Intent(LoginActivity.this, SocketService.class);
                        i.putExtra(SocketService.ID, entityID);
                        i.putExtra(SocketService.TOKEN, token);
//                        i.putExtra(SocketService.REFTOKEN, refToken);
                        i.putExtra(SocketService.BASETOKEN, baseToken.getText().toString());
                        startService(i);
                    }

                    @Override
                    public void onFailure(Call<TokenRefreshResponse> call, Throwable t) {
                        Log.d("bbken", "REFRESH TOKEN API FAILED");
                    }
                });
            }
        });
    }
}
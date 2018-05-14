package com.example.anin.cloudcamplayer.Presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.anin.cloudcamplayer.Model.RequestStreamResponse;
import com.example.anin.cloudcamplayer.R;
import com.example.anin.cloudcamplayer.Rest.APIClient;
import com.example.anin.cloudcamplayer.Rest.APIInterface;
import com.example.anin.cloudcamplayer.Service.SocketService;

import retrofit2.Call;
import retrofit2.Callback;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent i = getIntent();
        String sourceID = i.getStringExtra(SocketService.ID);
        String sourceToken = i.getStringExtra(SocketService.TOKEN);
        String baseToken = i.getStringExtra(SocketService.BASETOKEN);

        APIInterface service = APIClient.getClient().create(APIInterface.class);

        Call<RequestStreamResponse> call = service.stream("Bearer " + baseToken, "no-cache", "source", sourceID);
        call.enqueue(new Callback<RequestStreamResponse>() {
            @Override
            public void onResponse(Call<RequestStreamResponse> call, retrofit2.Response<RequestStreamResponse> response) {
                String gatewayUrl = response.body().getStream().getGatewayUrl();
                Log.d("bbken", gatewayUrl);
            }

            @Override
            public void onFailure(Call<RequestStreamResponse> call, Throwable t) {
                Log.d("bbken", t.getMessage());
            }
        });
    }
}

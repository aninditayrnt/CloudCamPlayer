package com.example.anin.cloudcamplayer.Service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.anin.cloudcamplayer.Presenter.PlayerActivity;
import com.neovisionaries.ws.client.HostnameUnverifiedException;
import com.neovisionaries.ws.client.OpeningHandshakeException;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;

public class SocketService extends IntentService{
//    private WebSocketFactory factory;

    public static String ID = "sid";
    public static String TOKEN = "acstkn";
    public static String REFTOKEN = "reftok";
    public static String BASETOKEN = "basetok";

    public SocketService() {
        super("SocketService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String sourceID = intent.getStringExtra(ID);
        String accessToken = intent.getStringExtra(TOKEN);
//        String refreshToken = intent.getStringExtra(REFTOKEN);
        String baseToken = intent.getStringExtra(BASETOKEN);
        Log.d("bbken", sourceID);
        Log.d("bbken", accessToken);
//        Log.d("bbken", refreshToken);
        Log.d("bbken", baseToken);

        try{
            WebSocket ws = new WebSocketFactory().createSocket("wss://api.dev.st-av.net/v1/mbus/websocket?source_id=" + sourceID);
            ws.addHeader("authorization", "Bearer " + accessToken);
            ws.addListener(new WebSocketAdapter(){
                @Override
                public void onConnected(WebSocket websocket, Map<String, List<String>> headers) throws Exception {
                    super.onConnected(websocket, headers);
                    Log.d("bbken", "CONNECTED");
                }
            });
            ws.connect();

            Intent i = new Intent(getBaseContext(), PlayerActivity.class);
            i.putExtra(ID, sourceID);
            i.putExtra(TOKEN, accessToken);
//            i.putExtra(REFTOKEN, refreshToken);
            i.putExtra(BASETOKEN, baseToken);
            getApplication().startActivity(i);
        }catch (OpeningHandshakeException e) {
            Log.d("bbken", e.getMessage());
        }catch(HostnameUnverifiedException e) {
            Log.d("bbken", e.getMessage());
        }catch (WebSocketException e) {
            Log.d("bbken", e.getMessage());
        }catch (IOException e) {
            Log.d("bbken", e.getMessage());
        }
    }
}

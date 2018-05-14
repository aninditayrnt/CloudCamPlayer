package com.example.anin.cloudcamplayer.Rest;

import com.example.anin.cloudcamplayer.Model.RequestStreamResponse;
import com.example.anin.cloudcamplayer.Model.TokenRefreshResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {
    @FormUrlEncoded
    @POST("v1/token_refresh")
    Call<TokenRefreshResponse> login(@Header("Authorization") String sourceToken, @Field("refresh_token") String refreshToken);

    @FormUrlEncoded
    @POST("v1/stream")
    Call<RequestStreamResponse> stream(@Header("Authorization") String baseToken, @Header("cache-control") String cacheControl, @Field("type") String type, @Field("source_id") String sourceID);
}

package com.kurban.mvvm.data.remote;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface ApiHelper {

    @GET("get/bUrVzugsZe")
    Call<RemoteModel> getData(@Query("indent") String indent);
}

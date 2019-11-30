package com.kurban.mvvm.data.remote;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class RetrofitService {

    static ApiHelper getApiHelper(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build();

        return retrofit.create(ApiHelper.class);
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.interceptors().add(interceptor);

        return httpClient.build();
    }
}

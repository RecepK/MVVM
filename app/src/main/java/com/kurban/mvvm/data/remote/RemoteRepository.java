package com.kurban.mvvm.data.remote;

import androidx.lifecycle.MutableLiveData;

import com.kurban.mvvm.BuildConfig;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteRepository {

    // { "value": "RemoteData: MVVM" }

    private MutableLiveData<RemoteModel> data = new MutableLiveData<>();

    public MutableLiveData<RemoteModel> getData(String value) {
        RetrofitService
                .getApiHelper(BuildConfig.BASE_URL)
                .getData(value)
                .enqueue(new Callback<RemoteModel>() {
                    @Override
                    public void onResponse(@NotNull Call<RemoteModel> call, @NotNull Response<RemoteModel> response) {
                        if (response.isSuccessful()) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<RemoteModel> call, @NotNull Throwable t) {
                        data.setValue(new RemoteModel("null"));
                    }
                });
        return data;
    }
}

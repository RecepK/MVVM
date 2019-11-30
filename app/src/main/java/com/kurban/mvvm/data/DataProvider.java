package com.kurban.mvvm.data;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.kurban.mvvm.data.local.LocalModel;
import com.kurban.mvvm.data.local.LocalRepository;
import com.kurban.mvvm.data.remote.RemoteModel;
import com.kurban.mvvm.data.remote.RemoteRepository;

public class DataProvider {

    private LocalRepository localRepository;
    private MutableLiveData<LocalModel> localLiveData = new MutableLiveData<>();

    private RemoteRepository remoteRepository;

    public DataProvider(@NonNull Context context) {
        localRepository = new LocalRepository(context);
        remoteRepository = new RemoteRepository();
    }

    public MutableLiveData<LocalModel> getLocalData() {
        localLiveData.setValue(localRepository.getData());
        return localLiveData;
    }

    public void buttonClicked() {
        localLiveData.postValue(localRepository.setData("M-V-VM"));
    }

    public MutableLiveData<RemoteModel> getRemoteData() {
        return remoteRepository.getData("2");
    }
}

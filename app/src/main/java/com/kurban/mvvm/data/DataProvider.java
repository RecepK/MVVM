package com.kurban.mvvm.data;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.kurban.mvvm.data.local.LocalModel;
import com.kurban.mvvm.data.local.LocalRepository;

public class DataProvider {

    private LocalRepository localRepository;
    private MutableLiveData<LocalModel> localLiveData = new MutableLiveData<>();


    public DataProvider(@NonNull Context context) {
        localRepository = new LocalRepository(context);
    }

    public MutableLiveData<LocalModel> getLocalData() {
        localLiveData.setValue(localRepository.getData());
        return localLiveData;
    }

    public void buttonClicked() {
        localLiveData.postValue(localRepository.setData("M-V-VM"));
    }
}

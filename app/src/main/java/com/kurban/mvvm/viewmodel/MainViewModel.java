package com.kurban.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurban.mvvm.data.DataProvider;
import com.kurban.mvvm.data.local.LocalModel;

public class MainViewModel extends ViewModel {

    private DataProvider dataProvider;

    public void init(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void buttonClicked() {
        dataProvider.buttonClicked();
    }

    public MutableLiveData<LocalModel> getLocalData() {
        return dataProvider.getLocalData();
    }
}
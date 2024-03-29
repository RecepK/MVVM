package com.kurban.mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kurban.mvvm.data.DataProvider;
import com.kurban.mvvm.data.local.LocalModel;
import com.kurban.mvvm.data.remote.RemoteModel;

import java.util.List;

public class MainViewModel extends ViewModel {

    private DataProvider dataProvider;

    public void init(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }

    public void buttonClicked() {
        dataProvider.buttonClicked();
    }

    //TODO
    public void buttonLongClicked() {
        LocalModel model = new LocalModel("LocalData");

        // insert
        insertDBData(model);

        // delete
        //deleteDBData(model);
    }

    public MutableLiveData<LocalModel> getLocalData() {
        return dataProvider.getLocalData();
    }

    public MutableLiveData<RemoteModel> getRemoteData() {
        return dataProvider.getRemoteData();
    }

    public void insertDBData(LocalModel model) {
        dataProvider.getLocalRepository().insertModel(model);
    }

    public void deleteDBData(LocalModel model) {
        dataProvider.getLocalRepository().deleteModel(model);
    }

    public LiveData<List<LocalModel>> getAllDBData() {
        return dataProvider.getLocalRepository().getAllModel();
    }

}

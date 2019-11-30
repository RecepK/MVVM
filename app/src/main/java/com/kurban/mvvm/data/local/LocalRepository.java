package com.kurban.mvvm.data.local;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.kurban.mvvm.R;

import java.util.List;

public class LocalRepository {

    private Context context;

    private DataDao dataDao;

    public LocalRepository(Context context) {
        this.context = context;
        dataDao = AppDatabase.getAppDatabase(context.getApplicationContext()).dataDao();
    }

    public LocalModel getData() {
        String data = "LocalData: " + context.getString(R.string.app_name);
        return new LocalModel(data);
    }

    public LocalModel setData(String value) {
        String data = "LocalData: " + value;
        return new LocalModel(data);
    }

    public void insertModel(LocalModel... model) {
        dataDao.insert(model);
    }

    public void deleteModel(LocalModel model) {
        dataDao.delete(model);
    }

    public LiveData<List<LocalModel>> getAllModel() {
        return dataDao.getAllData();
    }
}

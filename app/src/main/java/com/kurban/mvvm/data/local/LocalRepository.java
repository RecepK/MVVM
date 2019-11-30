package com.kurban.mvvm.data.local;

import android.content.Context;

import com.kurban.mvvm.R;

public class LocalRepository {

    private Context context;

    public LocalRepository(Context context) {
        this.context = context;
    }

    public LocalModel getData() {
        String data = "LocalData: " + context.getString(R.string.app_name);
        return new LocalModel(data);
    }

    public LocalModel setData(String value) {
        String data = "LocalData: " + value;
        return new LocalModel(data);
    }
}

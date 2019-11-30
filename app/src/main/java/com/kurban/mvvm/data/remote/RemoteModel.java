package com.kurban.mvvm.data.remote;

import com.google.gson.annotations.SerializedName;

public class RemoteModel {

    @SerializedName("value")
    private String value;

    RemoteModel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

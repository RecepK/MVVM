package com.kurban.mvvm.data.local;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "data")
public class LocalModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "value")
    private String value;

    @Ignore
    public LocalModel(String value) {
        this.value = value;
    }

    public LocalModel(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}

package com.kurban.mvvm.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.kurban.mvvm.R;
import com.kurban.mvvm.data.DataProvider;
import com.kurban.mvvm.data.local.LocalModel;
import com.kurban.mvvm.data.remote.RemoteModel;
import com.kurban.mvvm.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;

    private TextView tvLocal;
    private TextView tvRemote;
    private TextView tvDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        initViewModel();
        setViewModel();
    }

    private void initUI() {
        tvLocal = findViewById(R.id.localTextView);
        tvRemote = findViewById(R.id.remoteTextView);
        tvDatabase = findViewById(R.id.dbTextView);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonClicked();
            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                buttonLongClicked();
                return true;
            }
        });
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(MainActivity.this).get(MainViewModel.class);
        viewModel.init(new DataProvider(getApplicationContext()));
    }

    private void setViewModel() {
        viewModel.getLocalData().observe(MainActivity.this, localDataObserver);
        viewModel.getRemoteData().observe(MainActivity.this, remoteDataObserver);
        viewModel.getAllDBData().observe(MainActivity.this, dbDataObserver);
    }

    private void setTextLocal(String value) {
        tvLocal.setText(value);
    }

    private void buttonClicked() {
        viewModel.buttonClicked();
    }

    private void buttonLongClicked() {
        viewModel.buttonLongClicked();
    }

    private void setTextRemote(String value) {
        tvRemote.setText(value);
    }

    private void setTextDB(String value) {
        tvDatabase.setText(value);
    }

    // Local DataObserver
    private Observer<LocalModel> localDataObserver = new Observer<LocalModel>() {
        @Override
        public void onChanged(LocalModel localModel) {
            setTextLocal(localModel.getValue());
        }
    };

    // Remote DataObserver
    private Observer<RemoteModel> remoteDataObserver = new Observer<RemoteModel>() {
        @Override
        public void onChanged(RemoteModel remoteModel) {
            setTextRemote(remoteModel.getValue());
        }
    };

    private Observer<List<LocalModel>> dbDataObserver = new Observer<List<LocalModel>>() {
        @Override
        public void onChanged(List<LocalModel> localModels) {
            StringBuilder value = new StringBuilder("LocalModels:\n");
            for (LocalModel model : localModels) {
                value.append("\n").append(model.getValue());
            }
            setTextDB(value.toString());
        }
    };
}

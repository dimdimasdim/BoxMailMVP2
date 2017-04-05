package com.learn.dim.boxmail.presenter;

import android.content.Context;

import com.learn.dim.boxmail.adapter.MailAdapter;
import com.learn.dim.boxmail.model.MainModel;
import com.learn.dim.boxmail.service.ApiClient;
import com.learn.dim.boxmail.service.ApiInterface;
import com.learn.dim.boxmail.view.MainView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by DIM on 29/03/2017.
 */

public class MainPresenter {
    private final MainView mainView;
    private final Context context;
    private List<MainModel> models;
    private MailAdapter adapter;

    public MainPresenter(MainView mainView, Context context) {
        this.mainView = mainView;
        this.context = context;
    }

    public void loadData(){
        models = new ArrayList<>();
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<List<MainModel>> call = service.getInbox();
        mainView.onDataLoad(models);
        call.enqueue(new Callback<List<MainModel>>() {
            @Override
            public void onResponse(Call<List<MainModel>> call, Response<List<MainModel>> response) {
                models.clear();
                for (MainModel model : response.body()){
                    models.add(model);
                }
                mainView.setRv(adapter);
            }

            @Override
            public void onFailure(Call<List<MainModel>> call, Throwable t) {
                mainView.notifMe("gagal fetch");
            }
        });



    }
}

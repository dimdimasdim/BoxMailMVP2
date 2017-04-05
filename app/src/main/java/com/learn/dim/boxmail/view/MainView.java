package com.learn.dim.boxmail.view;

import android.support.v7.widget.RecyclerView;

import com.learn.dim.boxmail.model.MainModel;

import java.util.List;

/**
 * Created by Sidiq on 30/03/2017.
 */

public interface MainView {

    void setRv(RecyclerView.Adapter adapter);

    void notifMe(String message);
    void onDataLoad(List<MainModel> models);
}

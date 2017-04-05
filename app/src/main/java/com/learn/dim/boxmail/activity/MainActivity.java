package com.learn.dim.boxmail.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.learn.dim.boxmail.R;
import com.learn.dim.boxmail.adapter.MailAdapter;
import com.learn.dim.boxmail.model.MainModel;
import com.learn.dim.boxmail.model.SeassionManager;
import com.learn.dim.boxmail.presenter.LoginPresenter;
import com.learn.dim.boxmail.presenter.MainPresenter;
import com.learn.dim.boxmail.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView{
    @BindView(R.id.rv_list) RecyclerView rvList;
    SeassionManager seassion;

    private LoginPresenter loginPresenter;
    private MainPresenter presenter;
    private MailAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        insisialisasiPresenter();

        seassion = new SeassionManager(getApplicationContext());

        presenter.loadData();

    }

    private void insisialisasiPresenter() {
        presenter = new MainPresenter( this,this);
    }

    @Override
    public void setRv(RecyclerView.Adapter adapter) {
        rvList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void notifMe(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataLoad(List<MainModel> models) {
        adapter = new MailAdapter(this,models, R.layout.list_item);
        adapter.notifyDataSetChanged();
        rvList.setAdapter(adapter);
    }



}

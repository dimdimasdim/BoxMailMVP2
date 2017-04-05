package com.learn.dim.boxmail.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.learn.dim.boxmail.R;
import com.learn.dim.boxmail.model.SeassionManager;
import com.learn.dim.boxmail.presenter.LoginPresenter;
import com.learn.dim.boxmail.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{
    @BindView(R.id.et_username) EditText username;
    @BindView(R.id.et_password) EditText password;


    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        inisialisaiPresenterLogin();

        loginPresenter.checkSession();

    }

    @OnClick(R.id.btn_login)
    public void login(){
        String user = username.getText().toString();
        String pass = password.getText().toString();

        loginPresenter.checkLogin(user,pass);
    }

    public void inisialisaiPresenterLogin(){
        SeassionManager seassion = new SeassionManager(getApplicationContext());
        loginPresenter = new LoginPresenter(this,seassion);
    }


    @Override
    public void session(Context context) {
        Intent i = new Intent(context, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    @Override
    public void loadHalaman(Intent intent) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    @Override
    public void notifMe(String message) {
        Toast.makeText(getApplicationContext(),message, Toast.LENGTH_SHORT).show();
    }
}

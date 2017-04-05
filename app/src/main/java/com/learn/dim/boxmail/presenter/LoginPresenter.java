package com.learn.dim.boxmail.presenter;

import android.content.Context;
import android.content.Intent;

import com.learn.dim.boxmail.model.SeassionManager;
import com.learn.dim.boxmail.view.LoginView;

/**
 * Created by Sidiq on 30/03/2017.
 */

public class LoginPresenter {
    LoginView loginView;
    SeassionManager session;
    Intent intent;
    Context context;

    public LoginPresenter(LoginView loginView, SeassionManager session) {
        this.loginView = loginView;
        this.session = session;
    }


    public void checkLogin(String username, String password){
        if (username.trim().length() > 0 && password.trim().length() >0 ){
            if (username.equals("test") && password.equals("test")){
                session.createLoginSession("Dimas","Dimas@gmail.com");

                loginView.loadHalaman(intent);
            }else {
                loginView.notifMe("login gagal");
            }
        }else {
            loginView.notifMe("Lengkapi Uaername dan Password anda");
        }
    }


    public void  checkSession(){
        if (!session.isLoggedIn()){
            loginView.session(context);
        }
    }

}

package com.learn.dim.boxmail.view;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Dimas Prakoso on 30/03/2017.
 */

public interface LoginView {

    void session(Context context);

    void loadHalaman(Intent intent);

    void notifMe(String message);

}

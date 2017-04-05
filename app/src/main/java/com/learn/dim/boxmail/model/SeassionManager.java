package com.learn.dim.boxmail.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.learn.dim.boxmail.activity.MainActivity;

import java.util.HashMap;

/**
 * Created by Dimas Prakoso on 04/04/2017.
 */

public class SeassionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context mContext;

    public static  final String MYPREF="MyPref";
    public static  final String USERNAME= "name";
    public static  final String EMAIL = "email";
    public static  final String LOGGED = "IsLoggedIn";
    int PRIVATE_MODE =0;

    public SeassionManager(Context context) {
        this.mContext = context;
        pref = mContext.getSharedPreferences(MYPREF,PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String name, String email){
        editor.putBoolean(LOGGED, true);
        editor.putString(USERNAME, name);
        editor.putString(EMAIL, email);
        editor.commit();
    }

//     public void check(){
//         if (!this.isLoggedIn()){
//             Intent i = new Intent(mContext, MainActivity.class);

//             i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//             i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//             mContext.startActivity(i);
//         }
//     }

    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user =new HashMap<String, String>();
        user.put(USERNAME, pref.getString(USERNAME,null));
        user.put(EMAIL, pref.getString(EMAIL,null));
        return user;
    }

    public void logoutUser(){
        editor.clear();
        editor.commit();

        Intent i = new Intent(mContext,MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(i);
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(LOGGED,false);
    }
}

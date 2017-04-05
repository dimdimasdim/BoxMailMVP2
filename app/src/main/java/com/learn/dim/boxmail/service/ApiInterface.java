package com.learn.dim.boxmail.service;

import com.learn.dim.boxmail.model.MainModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DIM on 29/03/2017.
 */

public interface ApiInterface {
    @GET("inbox.json")
    Call<List<MainModel>> getInbox();
}

package com.khoirullatif.modul2_kel03.presenter;

import com.khoirullatif.modul2_kel03.model.DataItem;
import com.khoirullatif.modul2_kel03.utils.ListUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("api/users?page=2")
    Call<ListUserResponse> getList();

    @GET("api/users/{id}")
    Call<DataItem> getUser(@Path("id") int id);
}

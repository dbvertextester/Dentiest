package com.dbvetex.dentiest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {

    @POST
    Call<CustomerInfo> createPost(@Body CustomerInfo customerInfo);
}

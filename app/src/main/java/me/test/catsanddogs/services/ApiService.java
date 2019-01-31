package me.test.catsanddogs.services;


import me.test.catsanddogs.mvp.model.ApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("xim/api.php")
    Call<ApiResponse> getResponse(@Query("query") String query);
}

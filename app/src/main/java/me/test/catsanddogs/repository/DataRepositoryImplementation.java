package me.test.catsanddogs.repository;

import javax.inject.Inject;

import me.test.catsanddogs.constants.Constants;
import me.test.catsanddogs.di.Resolver;
import me.test.catsanddogs.mvp.model.ApiResponse;
import me.test.catsanddogs.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepositoryImplementation implements DataRepository {

    @Inject
    ApiService service;

    public DataRepositoryImplementation () {
        Resolver.getApiComponent().inject(this);
    }

    @Override
    public void getCat(final RepositoryCallback callback) {
        try {
            service.getResponse(Constants.Cat).enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    callback.onLoad(response.body());
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    callback.onLoad(null);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getDog(final RepositoryCallback callback) {
        try {
            service.getResponse(Constants.Dog).enqueue(new Callback<ApiResponse>() {
                @Override
                public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                    callback.onLoad(response.body());
                }

                @Override
                public void onFailure(Call<ApiResponse> call, Throwable t) {
                    callback.onLoad(null);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

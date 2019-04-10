package com.emon.retrofitmvvmlivedatademo2.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.emon.retrofitmvvmlivedatademo2.model.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProjectRepository {
    private static ProjectRepository projectRepository;
    private ApiService apiService;

    public ProjectRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiService.BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public static synchronized ProjectRepository getInstance() {
        if (projectRepository == null) {
            projectRepository = new ProjectRepository();

        }
        return projectRepository;
    }

    public LiveData<List<Model>> getData(Integer[]userId,String sort,String order){
        final MutableLiveData<List<Model>> data=new MutableLiveData<>();
        apiService.getData(userId,sort,order).enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }
}

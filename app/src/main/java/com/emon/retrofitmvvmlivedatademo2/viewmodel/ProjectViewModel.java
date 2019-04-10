package com.emon.retrofitmvvmlivedatademo2.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.emon.retrofitmvvmlivedatademo2.model.Model;
import com.emon.retrofitmvvmlivedatademo2.repository.ProjectRepository;

import java.util.List;

public class ProjectViewModel extends AndroidViewModel {
    LiveData<List<Model>>dataObsarvable;
    public ProjectViewModel(@NonNull Application application) {
        super(application);
        dataObsarvable= ProjectRepository.getInstance().getData(new Integer[]{1,3,5},"id",null);
    }
   public LiveData<List<Model>> getDataObsarvable(){
        return dataObsarvable;
    }
}

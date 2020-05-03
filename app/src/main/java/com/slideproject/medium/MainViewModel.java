package com.slideproject.medium;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private BlogRepository movieRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        movieRepository = new BlogRepository(application);
    }

    public LiveData<List<Blog>> getAllPublished() {
        return movieRepository.getMutableLiveData();
    }
}

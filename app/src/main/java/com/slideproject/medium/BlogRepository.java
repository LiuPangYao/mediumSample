package com.slideproject.medium;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BlogRepository {

    private ArrayList<Blog> publisheds = new ArrayList<>();
    private MutableLiveData<List<Blog>> mutableLiveData = new MutableLiveData<>();
    private Application application;
    private static final String TAG = "BlogRepository";

    public BlogRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Blog>> getMutableLiveData() {
        RestApiService apiService = RetrofitInstance.getApiService();
        Call<BlogWrapper> call = apiService.getAllPublished();
        call.enqueue(new Callback<BlogWrapper>() {

            @Override
            public void onResponse(Call<BlogWrapper> call, Response<BlogWrapper> response) {
                BlogWrapper mBlogWrapper = response.body();
                if (mBlogWrapper != null && mBlogWrapper.getItem() != null) {
                    publisheds = (ArrayList<Blog>) mBlogWrapper.getItem();
                    mutableLiveData.setValue(publisheds);
                } else {
                    Log.d(TAG, "onResponse: something error");
                }
            }

            @Override
            public void onFailure(Call<BlogWrapper> call, Throwable t) {
                Log.d(TAG, "onFailure: fail, " + t);
            }
        });
        return mutableLiveData;
    }
}

package com.slideproject.medium;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestApiService {

    @GET("api.json?rss_url=https://medium.com/feed/@Pang_Yao")
    Call<BlogWrapper> getAllPublished();
}

package com.zensolutions.Network;



import com.zensolutions.Model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RedditService {
    @GET("r/androiddev.json")
    Observable<UserResponse> fetchReddit();
}

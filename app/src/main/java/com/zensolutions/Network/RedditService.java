package com.zensolutions.Network;



import com.zensolutions.Model.UserResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface RedditService {
    @GET
    Observable<UserResponse> fetchReddit(@Url String url);
}

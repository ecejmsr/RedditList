package com.zensolutions.Utils;

import com.zensolutions.Network.ApiFactory;
import com.zensolutions.Network.RedditService;

import static com.zensolutions.Network.URL.BASE_URL;

public class ApiUtils {
    public static RedditService getSOService(){
        return ApiFactory.getClient(BASE_URL).create(RedditService.class);
    }
}

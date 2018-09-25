package com.zensolutions.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("data")
    @Expose

    private List<Data_> redditList= null;
    public List<Data_> getRedditList(){return redditList;}
    public void setRedditList(List<Data_> mRedditList){this.redditList= mRedditList;}
}

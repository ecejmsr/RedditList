package com.zensolutions.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("children")
    @Expose

    private List<Child> redditList= null;
    public List<Child> getRedditList(){return redditList;}
    public void setRedditList(List<Child> mRedditList){this.redditList= mRedditList;}
}

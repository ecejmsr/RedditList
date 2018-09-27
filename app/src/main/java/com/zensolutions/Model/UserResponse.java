package com.zensolutions.Model;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserResponse {
    @SerializedName("kind")
    @Expose
    private String listing;

    @SerializedName("data")
    @Expose
    private Data mData;

    public String getListing() {
        return listing;
    }

    public void setListing(String listing) {
        this.listing = listing;
    }

    public Data getData() {
        return mData;
    }

    public void setData(Data data) {
        mData = data;
    }
}

package com.zensolutions.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.zensolutions.Model.Data_;

public class ItemRedditViewModel extends BaseObservable{
    private Data_ reddit;
    private Context context;

    public ItemRedditViewModel(Data_ reddit, Context context){
        this.reddit= reddit;
        this.context= context;
    }

    public String getRedditTitle(){return reddit.getTitle();}

    public String getRedditAuthor(){return reddit.getAuthor();}

    public String getRedditCommentCount(){return Integer.toString(reddit.getNumComments());}

    public void onItemClick(){
        //INSERT DIALOG HERE
    }
}

package com.zensolutions.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.zensolutions.Model.Child;


public class ItemRedditViewModel extends BaseObservable{
    private Child reddit;
    private Context context;

    public ItemRedditViewModel(Child reddit, Context context){
        this.reddit= reddit;
        this.context= context;
    }

    public String getRedditTitle(){return reddit.getData().getTitle();}

    public String getRedditAuthor(){return reddit.getData().getAuthor();}

    public String getRedditCommentCount(){return Integer.toString(reddit.getData().getNumComments());}

    public void onItemClick(){
        //INSERT DIALOG HERE
    }
}

package com.zensolutions.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;

import com.zensolutions.Model.Child;
import com.zensolutions.Model.Data;
import com.zensolutions.Model.Data_;

import java.util.List;


public class ItemRedditViewModel extends BaseObservable{
    private Child reddit;
    private Context context;
    private List<Child> redditThreads= null;

    public ItemRedditViewModel(Child reddit, Context context){
        this.reddit= reddit;
        this.context= context;
    }

    public String getRedditTitle(){return reddit.getData().getAuthor(); }

    public String getRedditAuthor(){return reddit.getData().getAuthor();}

    public String getRedditCommentCount(){return Integer.toString(reddit.getData().getNum_comments());}

    public void onItemClick(){
        //INSERT DIALOG HERE
    }
}

package com.zensolutions.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.view.View;

import com.zensolutions.Model.Child;


public class ItemRedditViewModel extends BaseObservable{
    private Child reddit;
    private Context context;

    public ItemRedditViewModel(Child reddit, Context context){
        this.reddit= reddit;
        this.context= context;
    }

    public String getRedditTitle(){return reddit.getData().getAuthor(); }

    public String getRedditAuthor(){return reddit.getData().getAuthor();}

    public String getRedditCommentCount(){return Integer.toString(reddit.getData().getNum_comments());}

    public String getRedditSelfText(){return reddit.getData().getSelftext();}

    public void setReddit(Child reddit){
        this.reddit= reddit;
        notifyChange();
    }
}

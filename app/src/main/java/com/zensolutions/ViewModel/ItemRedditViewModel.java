package com.zensolutions.ViewModel;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.BaseObservable;
import android.view.View;

import com.zensolutions.Model.Child;
import com.zensolutions.simplelist.MainActivity;


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



    public void onClick(){
        AlertDialog alertDialog= new AlertDialog.Builder(context).create();
        alertDialog.setMessage(getRedditSelfText());
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
    }

    public void setReddit(Child reddit){
        this.reddit= reddit;
        notifyChange();
    }
}

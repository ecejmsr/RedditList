package com.zensolutions.ViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.databinding.ObservableInt;

import com.zensolutions.AppController;
import com.zensolutions.Model.Child;

import com.zensolutions.Model.Data;
import com.zensolutions.Model.UserResponse;
import com.zensolutions.Network.RedditService;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import static com.zensolutions.Network.URL.BASE_URL;

public class RedditViewModel extends Observable {
    public ObservableInt redditRecycler;

    private List<Child> redditList;
    private Context context;
    private CompositeDisposable mCompositeDisposable= new CompositeDisposable();

    public RedditViewModel(Context context){
        this.context= context;
        this.redditList= new ArrayList<>();
        redditRecycler= new ObservableInt();
        fetchRedditList();
    }

    private void fetchRedditList(){
        final AppController appController= AppController.create(context);
        final RedditService redditService= appController.getRedditService();

        Disposable disposable= redditService.fetchReddit()
                                        .subscribeOn(appController.subcribeScheduler())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe(new Consumer<UserResponse>(){
                                            @Override
                                            public void accept(UserResponse userResponse) throws Exception{
                                                updateRedditDataList(userResponse.getData().getChildren());
                                            }
                                        });
        mCompositeDisposable.add(disposable);
    }

    private void updateRedditDataList(List<Child> reddit){
        redditList.addAll(reddit);
        setChanged();
        notifyObservers();
    }

    public List<Child> getRedditList(){return redditList;}

    private void unSubcribeFromObservable(){
        if(mCompositeDisposable != null && !mCompositeDisposable.isDisposed()){
            mCompositeDisposable.dispose();
        }
    }

    public void reset(){
        unSubcribeFromObservable();
        mCompositeDisposable= null;
        context= null;
    }
}

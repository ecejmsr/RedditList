package com.zensolutions.simplelist;

import android.databinding.DataBindingUtil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zensolutions.ViewModel.RedditViewModel;
import com.zensolutions.simplelist.databinding.ActivityMainBinding;

import java.util.Observable;
import java.util.Observer;


public class MainActivity extends AppCompatActivity implements Observer {
    private ActivityMainBinding redditActivityBinding;
    private RedditViewModel redditViewModel;
    private RedditAdapter redditAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();
        setUpListOfReddit(redditActivityBinding.redditList);
        setUpObserver(redditViewModel);
    }


    @Override
    public void update(java.util.Observable observable, Object o) {
        if(observable instanceof RedditViewModel){
            final RedditAdapter redditAdapter= (RedditAdapter) redditActivityBinding.redditList.getAdapter();
            RedditViewModel redditViewModel= (RedditViewModel) observable;
            redditAdapter.setRedditList(redditViewModel.getRedditList());
        }
    }

    private void initDataBinding(){
        redditActivityBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        redditViewModel = new RedditViewModel(this);
        redditActivityBinding.setRedditViewModel(redditViewModel);
    }

    private void setUpListOfReddit(RecyclerView listReddit){
        listReddit.setLayoutManager(new LinearLayoutManager(this));
        RedditAdapter redditAdapter= new RedditAdapter(getApplicationContext());
        listReddit.setAdapter(redditAdapter);
    }

    public void setUpObserver(Observable observable){observable.addObserver(this);}

    @Override
    protected void onDestroy(){
        super.onDestroy();
        redditViewModel.reset();
    }
}

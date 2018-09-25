package com.zensolutions.simplelist;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zensolutions.Model.Data_;
import com.zensolutions.ViewModel.ItemRedditViewModel;
import com.zensolutions.simplelist.databinding.ItemRedditBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.RedditAdapterViewHolder>{
    private List<Data_> redditList;
    private List<Data_> filteredDataList= new ArrayList<>();
    private List<Data_> savedDataList= new ArrayList<>();

    public RedditAdapter(){this.redditList= Collections.emptyList();}

    @NonNull
    @Override
    public RedditAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRedditBinding itemRedditBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_reddit, parent, false);
        return new RedditAdapterViewHolder(itemRedditBinding);
    }

    @Override
    public void onBindViewHolder(@android.support.annotation.NonNull RedditAdapterViewHolder holder, int position) {
        holder.bindReddit(filteredDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return filteredDataList.size();
    }

    public void setRedditList(List<Data_> redditList){
        this.redditList= redditList;
        filteredDataList= redditList;
        savedDataList= redditList;
        notifyDataSetChanged();
    }


    public static class RedditAdapterViewHolder extends RecyclerView.ViewHolder{
        ItemRedditBinding itemRedditBinding;

        public RedditAdapterViewHolder(ItemRedditBinding itemRedditBinding) {
            super(itemRedditBinding.relativeLayout);
            this.itemRedditBinding = itemRedditBinding;
        }

        void bindReddit(Data_ reddit){
            if(itemRedditBinding.getRedditViewModel()==null){
                itemRedditBinding.setRedditViewModel(new ItemRedditViewModel(reddit, itemView.getContext()));
            }
            else{
                itemRedditBinding.getRedditViewModel();
            }
        }
    }
}
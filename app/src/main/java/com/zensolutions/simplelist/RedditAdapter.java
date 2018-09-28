package com.zensolutions.simplelist;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zensolutions.Model.Child;

import com.zensolutions.Model.Data;
import com.zensolutions.ViewModel.ItemRedditViewModel;
import com.zensolutions.simplelist.databinding.ItemRedditBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.reactivex.annotations.NonNull;

public class RedditAdapter extends RecyclerView.Adapter<RedditAdapter.RedditAdapterViewHolder>{
    private List<Child> filteredDataList;
    private Context context;

    public RedditAdapter(){
        this.filteredDataList= Collections.emptyList();
        this.context= context;
    }

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

    public void setRedditList(List<Child> redditList){
        this.filteredDataList= redditList;
        notifyDataSetChanged();
    }


    public static class RedditAdapterViewHolder extends RecyclerView.ViewHolder{
        ItemRedditBinding itemRedditBinding;

        public RedditAdapterViewHolder(ItemRedditBinding itemRedditBinding) {
            super(itemRedditBinding.relativeLayout);
            this.itemRedditBinding = itemRedditBinding;
        }

        void bindReddit(Child reddit){
            if(itemRedditBinding.getRedditViewModel()==null){
                itemRedditBinding.setRedditViewModel(new ItemRedditViewModel(reddit, itemView.getContext()));
            }
            else{
                itemRedditBinding.getRedditViewModel().setReddit(reddit);
            }
        }
    }
}

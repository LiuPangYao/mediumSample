package com.slideproject.medium;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class BlogWrapper {

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    public Detail getFeed() {
        return mFeed;
    }

    public void setFeed(Detail feed) {
        this.mFeed = feed;
    }

    public List<Blog> getItem() {
        return mItem;
    }

    public void setItem(List<Blog> items) {
        this.mItem = items;
    }

    @SerializedName("status")
    private String mStatus;
    //@SerializedName("feed")
    //private String mFeed;
    @SerializedName("feed")
    private Detail mFeed;
    @SerializedName("items")
    private List<Blog> mItem;
}

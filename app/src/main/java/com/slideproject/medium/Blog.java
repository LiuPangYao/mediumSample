package com.slideproject.medium;

import com.google.gson.annotations.SerializedName;

public class Blog {

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getPubDate() {
        return mPubDate;
    }

    public void setPubDate(String pubDate) {
        this.mPubDate = pubDate;
    }

    public String getLink() {
        return mLink;
    }

    public void setLink(String link) {
        this.mLink = link;
    }

    public String getGuide() {
        return mGuide;
    }

    public void setGuide(String guide) {
        this.mGuide = guide;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        this.mAuthor = author;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    /*public String getEnclosure() {
        return mEnclosure;
    }

    public void setEnclosure(String enclosure) {
        this.mEnclosure = enclosure;
    }*/

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.mThumbnail = thumbnail;
    }

    /*public String getCategories() {
        return mCategories;
    }

    public void setCategories(String categories) {
        this.mCategories = categories;
    }*/

    @SerializedName("title")
    private String mTitle;
    @SerializedName("pubDate")
    private String mPubDate;
    @SerializedName("link")
    private String mLink;
    @SerializedName("guide")
    private String mGuide;
    @SerializedName("author")
    private String mAuthor;
    @SerializedName("description")
    private String mDescription;
    //@SerializedName("enclosure")
    //private String mEnclosure;
    @SerializedName("thumbnail")
    private String mThumbnail;
    //@SerializedName("categories")
    //private String mCategories;

}

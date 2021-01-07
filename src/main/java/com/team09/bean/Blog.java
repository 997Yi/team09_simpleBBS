package com.team09.bean;

import java.util.Date;

/**
 * @author team09
 */
public class Blog {

    private String id;

    private String title;

    private String keyWords;

    private Date time;

    private int clicks;

    private String context;

    private boolean isTop;

    private boolean isQuintessence;

    public Blog() {
    }

    public Blog(String title, String keyWords, Date time, int clicks, String context, boolean isTop, boolean isQuintessence) {
        this.title = title;
        this.keyWords = keyWords;
        this.time = time;
        this.clicks = clicks;
        this.context = context;
        this.isTop = isTop;
        this.isQuintessence = isQuintessence;
    }


    public Blog(String id, String title, String keyWords, Date time, int clicks, String context, boolean isTop, boolean isQuintessence) {
        this.id = id;
        this.title = title;
        this.keyWords = keyWords;
        this.time = time;
        this.clicks = clicks;
        this.context = context;
        this.isTop = isTop;
        this.isQuintessence = isQuintessence;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public boolean isQuintessence() {
        return isQuintessence;
    }

    public void setQuintessence(boolean quintessence) {
        isQuintessence = quintessence;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

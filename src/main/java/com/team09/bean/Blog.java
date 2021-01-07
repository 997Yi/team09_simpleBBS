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

    private long clicks;

    private String context;

    public Blog() {
    }

    public Blog(String id, String title, String keyWords, Date time, long clicks, String context) {
        this.id = id;
        this.title = title;
        this.keyWords = keyWords;
        this.time = time;
        this.clicks = clicks;
        this.context = context;
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

    public long getClicks() {
        return clicks;
    }

    public void setClicks(long clicks) {
        this.clicks = clicks;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}

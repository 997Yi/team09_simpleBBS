package com.team09.bean;


import java.util.Date;

/**
 * @author team09
 */
public class Comment {

    private String id;

    private String content;

    private String status;

    private Date time;

    private String userId;

    private String blogId;

    public Comment() {
    }

    public Comment(String content, String status, Date time, String userId, String blogId) {
        this.content = content;
        this.status = status;
        this.time = time;
        this.userId = userId;
        this.blogId = blogId;
    }

    public Comment(String id, String content, String status, Date time, String userId, String blogId) {
        this(content, status, time, userId, blogId);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId;
    }
}

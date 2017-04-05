package com.learn.dim.boxmail.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DIM on 29/03/2017.
 */

public class MainModel {

    @SerializedName("id")
    private Integer id;
    @SerializedName("isImportant")
    private Boolean isImportant;
    @SerializedName("picture")
    private String picture;
    @SerializedName("from")
    private String from;
    @SerializedName("subject")
    private String subject;
    @SerializedName("message")
    private String message;
    @SerializedName("timestamp")
    private String timestamp;
    @SerializedName("isRead")
    private Boolean isRead;

    public MainModel(Integer id, Boolean isImportant, String picture, String from, String subject, String message, String timestamp, Boolean isRead) {
        this.id = id;
        this.isImportant = isImportant;
        this.picture = picture;
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.timestamp = timestamp;
        this.isRead = isRead;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getIsImportant() {
        return isImportant;
    }

    public void setIsImportant(Boolean isImportant) {
        this.isImportant = isImportant;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

}

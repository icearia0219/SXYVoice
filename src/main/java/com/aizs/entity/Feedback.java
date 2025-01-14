package com.aizs.entity;

import java.sql.Timestamp;

public class Feedback {
    private Long feedbackid; // 主键
    private Long userid; // 用户ID
    private String content; // 反馈内容
    private Timestamp created_at; // 创建时间

    // Getters and Setters
    public Long getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Long feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackid=" + feedbackid +
                ", userid=" + userid +
                ", content='" + content + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}

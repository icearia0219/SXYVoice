package com.aizs.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FeedbackDTO {
    private Long feedbackid;
    private Long userid;
    private String content;
    private Timestamp created_at; // 确保这是 ISO 8601 格式的字符串

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
}
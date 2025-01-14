package com.aizs.dto;

import lombok.Data;

@Data
public class UserQueryDto {
    public Integer currentPage;
    //页面展示条数
    public Integer pageSize;
    //查询的起始下标
    public Integer startIndex;

    private String userid;
    private  String  username;
    //计算起始下标
    public Integer getStartIndex() {

        return (this.currentPage-1)*this.pageSize;
    }
}

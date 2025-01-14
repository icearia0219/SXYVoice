package com.aizs.service;

import cn.dev33.satoken.util.SaResult;
import com.aizs.dto.UserQueryDto;
import com.aizs.entity.User;

import java.util.List;

public interface UserManagementService {
    SaResult getUsers(UserQueryDto userQueryDto);
    SaResult getUsersByUsername(UserQueryDto userQueryDto);
    //单条删除
    SaResult deleteUser(Integer userId);
    //批量删除
    SaResult removeUsers(List<Integer> userids);
    //更新信息
    SaResult updateUser(Long userId, User user);
}

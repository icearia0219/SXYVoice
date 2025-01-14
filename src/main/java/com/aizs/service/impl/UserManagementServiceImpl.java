package com.aizs.service.impl;

import cn.dev33.satoken.util.SaResult;
import com.aizs.dto.UserQueryDto;
import com.aizs.entity.User;
import com.aizs.mapper.UserManagementMapper;
import com.aizs.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserManagementServiceImpl implements UserManagementService {
    @Autowired
    private UserManagementMapper userMapper;

    @Override
    public SaResult getUsers(UserQueryDto userQueryDto) {

        List<User> users = userMapper.selectUsers(userQueryDto);
        int count = userMapper.selectUsersCount(userQueryDto);  // 获取总数

        Map<String, Object> map = new HashMap<>();
        map.put("userInfos", users);
        map.put("totals", count); // 更新总记录数

        return SaResult.get(200, "查询成功！", map);
    }
    @Override
    public SaResult getUsersByUsername(UserQueryDto userQueryDto) {
        List<User> users = userMapper.selectUsersByUsername(userQueryDto);
        int count = userMapper.selectUsersCountByUsername(userQueryDto);  // 获取总数

        Map<String, Object> map = new HashMap<>();
        map.put("userInfos", users);
        map.put("totals", count); // 更新总记录数

        return SaResult.get(200, "查询成功！", map);
    }
    //单条删除
    @Override
    public SaResult deleteUser(Integer userId) {
        int result = userMapper.deleteUserById(userId);
        if (result > 0) {
            return SaResult.get(200, "删除成功！", null);
        } else {
            return SaResult.get(404, "用户未找到！", null);
        }
    }
    //批量删除
    @Override
    public SaResult removeUsers(List<Integer>  userids) {
        int num = userMapper.deleteBatchIds(userids);
        return SaResult.ok("已有"+num+"数据删除成功！");
    }
    //更新信息
    @Override
    public SaResult updateUser(Long userId, User user) {
        System.out.println("进入修改用户信息请求");
        user.setUserid(userId);
        int result = userMapper.updateUser(user);
        if (result > 0) {
            return SaResult.get(200, "修改成功！", null);
        } else {
            return SaResult.get(404, "用户未找到或修改失败！", null);
        }
    }

}

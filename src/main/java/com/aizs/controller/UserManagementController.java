package com.aizs.controller;

import cn.dev33.satoken.util.SaResult;
import com.aizs.dto.UserQueryDto;
import com.aizs.entity.User;
import com.aizs.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserManagementController {
    @Autowired
    private  UserManagementService  userManagementService;

    @GetMapping("/users")
    public SaResult getUsers(UserQueryDto userQueryDto) {
        System.out.println("进入查询用户请求");

        if (userQueryDto.getUsername() == null || userQueryDto.getUsername().isEmpty()) {
            // 如果 username 为空，调用全表查询
            return userManagementService.getUsers(userQueryDto);
        } else {
            // 否则，调用根据 username 查询的方法
            return userManagementService.getUsersByUsername(userQueryDto);
        }
    }

    //单条删除
    @DeleteMapping("/delete/{id}")
    public SaResult deleteUser(@PathVariable("id") Integer userId) {
        // 调用服务层删除用户的方法
        System.out.println("进入单条删除用户请求");
        return userManagementService.deleteUser(userId);
    }

    //批量删除
    @PostMapping("/deletes")
    public SaResult deleteUsers(@RequestBody List<Integer> userids) {
        System.out.println("进入批量删除用户请求");
        if (userids == null || userids.isEmpty()) {
            return SaResult.error("ID 列表不能为空");
        }
        try {
            // 执行删除操作
            return userManagementService.removeUsers(userids);
        } catch (Exception e) {
            e.printStackTrace();
            return SaResult.error("删除操作失败：" + e.getMessage());
        }

    }
//    更新信息
    @PutMapping("/update/{id}")
    public SaResult updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
        return userManagementService.updateUser(userId, user);
    }
}

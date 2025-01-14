package com.aizs.mapper;

import com.aizs.dto.UserQueryDto;
import com.aizs.entity.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserManagementMapper {
    List<User> selectUsers(UserQueryDto userQueryDto);
    Integer selectUsersCount(UserQueryDto userQueryDto);

    List<User> selectUsersByUsername(UserQueryDto userQueryDto);
    Integer selectUsersCountByUsername(UserQueryDto userQueryDto);
     //单条删除
    int deleteUserById(Integer userId);
    //批量删除
    int deleteBatchIds(@Param("ids") List<Integer> ids);
    //更新数据
    int updateUser(User user);
}

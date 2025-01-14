package com.aizs.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.aizs.dto.UserDTO;
import com.aizs.entity.User;
import com.aizs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setAge(userDTO.getAge());
        user.setProvince(userDTO.getProvince());
        user.setCity(userDTO.getCity());
        user.setBloodtype(userDTO.getBloodtype());
        user.setGender(userDTO.getGender());
        User registeredUser = userService.register(user);
        return registeredUser != null ? "Registration successful" : "Registration failed";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO userDTO) {
        User user = userService.login(userDTO.getUsername(), userDTO.getPassword());
        if (user != null) {
            StpUtil.login(user.getUserid().toString());
            StpUtil.getSession().set("role", user.getRole());
            String token = StpUtil.getTokenValue();
            return "Login successful, token: " + token;
        } else {
            return "Invalid username or password";
        }
    }

    @GetMapping("/user/info")
    public ResponseEntity<User> getUserInfo() {
        Long userId = StpUtil.getLoginIdAsLong();
        if (userId == null) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        User user = userService.getUserById(userId);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // 打印从会话中获取的角色信息用于调试
        String roleInSession = (String) StpUtil.getSession().get("role");
        System.out.println("Role from session: " + roleInSession);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/user/update")
    public String updateUser(@RequestBody UserDTO userDTO) {
        Long userId = StpUtil.getLoginIdAsLong();
        if (userId == null) {
            return "Unauthorized";
        }
        User user = userService.getUserById(userId);
        if (user == null) {
            return "User not found";
        }
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setGender(userDTO.getGender());
        user.setAge(userDTO.getAge());
        user.setProvince(userDTO.getProvince());
        user.setCity(userDTO.getCity());
        user.setBloodtype(userDTO.getBloodtype());
        userService.updateUser(user);
        return "Update successful";
    }

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<String> handleOptionsRequest() {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
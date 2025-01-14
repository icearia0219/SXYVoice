package com.aizs.entity;

public class User {
    private Long userid; // 用户ID (主键)
    private String username; // 用户名
    private String password; // 密码
    private String role; // 角色 (ENUM: 'worker', 'admin', 'system_admin')
    private String gender; // 性别 (ENUM: 'male', 'female')
    private Integer age; // 年龄
    private String province; // 省份
    private String city; // 城市
    private String bloodtype; // 血型 (ENUM: 'A', 'B', 'AB', 'O')

    // Getters and Setters
    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", bloodtype='" + bloodtype + '\'' +
                '}';
    }
}

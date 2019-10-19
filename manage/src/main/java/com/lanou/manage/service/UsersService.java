package com.lanou.manage.service;

import com.lanou.manage.bean.Users;

import java.util.List;

public interface UsersService {
    public List<Users> userList();
    public int findUser(Integer account);
    public int addUser(Users users);
    public int updateUser(Users users);
    //删除用户
    public int deleteUser(Integer account);




    //登录
    Users isLogin(Users users);
}

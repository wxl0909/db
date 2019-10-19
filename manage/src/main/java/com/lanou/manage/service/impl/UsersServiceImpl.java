package com.lanou.manage.service.impl;

import com.lanou.manage.bean.Users;
import com.lanou.manage.mapper.UsersMapper;
import com.lanou.manage.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;


    @Override
    public List<Users> userList() {
        return usersMapper.userList();
    }

    @Override
    public int findUser(Integer account) {
        return usersMapper.findUser(account);
    }

    @Override
    public int addUser(Users users) {
        return usersMapper.addUser(users);
    }

    @Override
    public int updateUser(Users users) {
        return usersMapper.updateUser(users);
    }

    @Override
    public int deleteUser(Integer account) {
        return usersMapper.deleteUser(account);
    }
    @Override
    public Users isLogin(Users users) {
        return usersMapper.isLogin(users);
    }
}

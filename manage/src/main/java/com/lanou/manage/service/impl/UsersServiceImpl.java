package com.lanou.manage.service.impl;

import com.lanou.manage.bean.Users;
import com.lanou.manage.mapper.UsersMapper;
import com.lanou.manage.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users isLogin(Users users) {
        return usersMapper.isLogin(users);
    }
}

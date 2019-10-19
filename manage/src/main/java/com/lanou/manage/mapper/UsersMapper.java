package com.lanou.manage.mapper;

import com.lanou.manage.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Mapper
@Component
public interface UsersMapper {
    //登录验证
    Users isLogin(Users users);

}

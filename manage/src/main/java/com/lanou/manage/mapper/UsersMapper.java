package com.lanou.manage.mapper;

import com.lanou.manage.bean.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UsersMapper {
    //查询手机号或账号存在
    public List<Users> userList();
    //添加用户
    public int findUser(Integer account);
    public int addUser(Users users);
    //修改用户
    public int updateUser(Users users);
    //删除用户
    public int deleteUser(Integer account);
}

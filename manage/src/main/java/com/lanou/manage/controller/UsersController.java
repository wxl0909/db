package com.lanou.manage.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.manage.bean.Users;
import com.lanou.manage.service.UsersService;
import com.lanou.manage.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    //登录验证
    @RequestMapping("isLogin")
    public String isLogin(Users users){
        Map map = new HashMap();
        Users userInfo = null;
        if (users.getAccount()!=null && !users.getAccount().equals("") && users.getPassword()!=null
            && !users.getPassword().equals("")){
            userInfo = usersService.isLogin(users);
            map.put("status",1);
            map.put("user",users);
        }
        if (users.getTelphone()!=null && !users.getTelphone().equals("")){
            //判断该号码是否存在数据库
            userInfo = usersService.isLogin(users);
            if (userInfo!=null){
                map.put("status",1);
                map.put("user",userInfo);
                String code = SendSms.sendMsg(userInfo.getTelphone());
                map.put("code",code);
            }else{
                map.put("status",0);
            }
        }
        return JSON.toJSONString(map);
    }

}

package com.lanou.manage.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.manage.bean.Users;
import com.lanou.manage.service.UsersService;
import com.lanou.manage.util.SendSms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("user")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("userList")
    public String userList(){
    List<Users> usersList = usersService.userList();
    return JSON.toJSONString(usersList);
    }

    @RequestMapping("addUser")
    public String addUser(Users users){
        int num = 0;
        for (int i = 1; i < 2; i ++){
            Random random = new Random();
            Integer n = random.nextInt(899999)+1;
            int u = usersService.findUser(n);
            if (u <= 0){
                users.setAccount(n.toString());
                System.out.println(n);
                num = usersService.addUser(users);
            }else {
                i--;
            }
        }
        return JSON.toJSONString(num);
    }

    @RequestMapping("updateUser")
    public String updateUser(Users users){
        int num = usersService.updateUser(users);
        return JSON.toJSONString(num);
    }

    @RequestMapping("deleteUser")
    public String deleteUser(Integer account){
        int num = usersService.deleteUser(account);
        return JSON.toJSONString(num);
    }


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

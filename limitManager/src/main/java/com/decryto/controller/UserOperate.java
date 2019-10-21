package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.decryto.bean.Permit;
import com.decryto.bean.Role;
import com.decryto.bean.User;
import com.decryto.service.RoleService;
import com.decryto.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userOper")
public class UserOperate {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    /*增删改*/
    @RequestMapping("/saveUser")
    @ResponseBody
    public String saveUser(User user, HttpSession session){
        int userInfo = 0;
        if (session.getAttribute("user")!=null){
                userInfo = userService.saveUser(user);
        }
        return JSON.toJSONString(userInfo);
    }


    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user, HttpSession session){
       int n = userService.updateUser(user);
        return JSON.toJSONString(n);
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(User user, HttpSession session){
        int n = userService.updateUser(user);
        return JSON.toJSONString(n);
    }
    @RequestMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(Integer id, HttpSession session){
        int n = userService.delUser(id);
        return JSON.toJSONString(n);
    }

    //管理员模块

    //管理员列表
    @ResponseBody
    @RequestMapping("/findUserList")
    public String findUserList(Integer pageNum,Integer pageSize){
        //分页
        Page<User> page = PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userService.findUserList();
        //分页1
        PageInfo<User> pageInfo = new PageInfo(userList);
        Map map = new HashMap();
        map.put("code","0");
        map.put("message","");
        map.put("count",pageInfo.getTotal());
        map.put("pageInfo",pageInfo);
        return JSON.toJSONString(map);
    }
    //修改管理员信息
    @ResponseBody
    @RequestMapping("/uptUser")
    public String uptUser(User user){
        int n = userService.uptUser(user);
        return JSON.toJSONString(n);
    }
    //删除角色和角色对应的权限菜单节点
    @ResponseBody
    @RequestMapping("/delPUser")
    public String delPUInfo(Integer id,Integer userRoleId){
        //删除角色
        int n1 = userService.delUser(id);
        //删除角色对应的权限节点
        int n2 = userService.delPUser(userRoleId);
        Map map = new HashMap();
        map.put("n1",n1);
        map.put("n2",n2);
        return JSON.toJSONString(map);
    }
    //添加管理员+添加对应的权限节点
    @RequestMapping("/intUser")
    @ResponseBody
    public String insertUser(User user){
    //
        int n = userService.saveUser(user);

        return JSON.toJSONString(n);
    }
    @RequestMapping("/AllUser")
    @ResponseBody
    public String allUser(){


        List<Role> roleList = roleService.selAllRole();

        return JSON.toJSONString(roleList);
    }

}

package com.decryto.controller;

import com.alibaba.fastjson.JSON;
import com.decryto.bean.Permit;
import com.decryto.bean.User;
import com.decryto.service.PermitService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/permit")
@Controller
public class PermitController {

    @Autowired
    private PermitService permitService;
    //查询权限
    @ResponseBody
    @RequestMapping("/queryPermit")
    public String queryPermit(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer uid = user.getId();
        List<Permit> permitList = null;

        if (uid!=null){
            permitList = permitService.queryPermit(uid);
        }
        /*转为树形结构  tree*/
       /* JSONArray jsonArray = JSONArray.parseArray(JSON.toJSONString(permitList));
        JSONArray jsonArray1 = JsonUtil.listToTree(jsonArray,"id","permitParentId","child");*/
        return JSON.toJSONString(permitList);
    }
//查询菜单列表
    @RequestMapping("/findAllPermit")
    @ResponseBody
    public String findAllPermit(Integer pageNum,Integer pageSize){
        //分页
        Page<Permit> page = PageHelper.startPage(pageNum,pageSize);
        List<Permit> permitList  = permitService.findAllPermit();
        //分页1
        PageInfo<Permit> pageInfo = new PageInfo<>(permitList);
        Map map = new HashMap();
        map.put("code","0");
        map.put("message","");
        map.put("count",pageInfo.getPageSize());
        map.put("pageInfo",pageInfo);
        //分页效果
        return JSON.toJSONString(map);
    }

    @RequestMapping("/pageHelperTest")
    @ResponseBody
    public String findsAllPermit(Integer pageNum,Integer pageSize){

        Page<Permit> page = PageHelper.startPage(pageNum,pageSize);
        //自带拦截器, 将查询的数据自带分开
        List<Permit> permitList = permitService.findAllPermit();
       PageInfo<Permit> pageInfo = new PageInfo<>(permitList);
        return JSON.toJSONString(pageInfo);
    }

}

package com.lanou.manage.controller;

import com.alibaba.fastjson.JSON;
import com.lanou.manage.bean.Emp;
import com.lanou.manage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    /*int addEmp(Emp emp);
    int uptEmpById(Integer id);
    int delEmpById(Integer id);*/
    @RequestMapping("addEmp")
    public String addEmp(Emp emp){
        int n = 0;
        if (emp!=null){
            n = empService.addEmp(emp);
        }

        return JSON.toJSONString(n);
    }
    @RequestMapping("uptEmpById")
    public String uptEmpById(Integer eid){
        int n = 0;
        if (eid!=null){
            n = empService.uptEmpById(eid);
        }

        return JSON.toJSONString(n);
    }
    @RequestMapping("delEmpById")
    public String delEmpById(Integer eid){
        int n = 0;
        if (eid!=null){
            n = empService.delEmpById(eid);
        }

        return JSON.toJSONString(n);
    }
}

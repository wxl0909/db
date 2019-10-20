package com.lanou.manage.service;

import com.lanou.manage.bean.Emp;

public interface EmpService {
    public Emp findAllEmp();
    int addEmp(Emp emp);
    int uptEmpById(Integer id);
    int delEmpById(Integer id);
}

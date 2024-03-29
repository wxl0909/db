package com.lanou.manage.service.impl;

import com.lanou.manage.bean.Emp;
import com.lanou.manage.mapper.EmpMapper;
import com.lanou.manage.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public Emp findAllEmp() {
        return empMapper.findAllEmp();
    }

    @Override
    public int addEmp(Emp emp) {
        return empMapper.addEmp(emp);
    }

    @Override
    public int uptEmpById(Integer id) {
        return empMapper.uptEmpById(id);
    }

    @Override
    public int delEmpById(Integer id) {
        return empMapper.delEmpById(id);
    }
}

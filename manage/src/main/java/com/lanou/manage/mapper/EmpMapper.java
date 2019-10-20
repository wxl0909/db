package com.lanou.manage.mapper;

import com.lanou.manage.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmpMapper {
    public Emp findAllEmp();
    int addEmp(Emp emp);
    int uptEmpById(Integer eid);
    int delEmpById(Integer eid);
}

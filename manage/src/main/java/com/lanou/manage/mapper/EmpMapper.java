package com.lanou.manage.mapper;

import com.lanou.manage.bean.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface EmpMapper {
    public Emp findAllEmp();
}

package com.atguigu.crud.dao;

import com.atguigu.crud.bean.Employee;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface EmployeeMapper extends Mapper<Employee> {

    List<Employee> getEmpList();
}

package com.atguigu.crud.service;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.dao.EmployeeMapper;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    public Employee getOne(Employee employeeCondition) {
        return employeeMapper.selectOne(employeeCondition);
    }

    public Employee getEmployeeById(Integer empId) {
        return  employeeMapper.selectByPrimaryKey(empId);
    }

    public boolean isExists(Integer empId) {
        return employeeMapper.existsWithPrimaryKey(empId);
    }

    public void saveEmployee(Employee employee) {
        employeeMapper.insert(employee);
    }

    public void saveEmployeeSelective(Employee employee) {
        employeeMapper.insertSelective(employee);
    }

    public void updateEmployeeSelective(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    public void deleteEmployeeByPrimaryKey(Integer empId) {
        employeeMapper.deleteByPrimaryKey(empId);
    }

    public List<Employee> getEmpListByExample(Example example) {
        return employeeMapper.selectByExample(example);
    }

    public List<Employee> getEmpList() {
        return employeeMapper.getEmpList();
    }
}

package com.atguigu.crud.test;

import com.atguigu.crud.bean.Employee;
import com.atguigu.crud.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:spring/applicationContext.xml"})
public class EmployeeMapperTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testSelectOne(){
        Employee employeeCondition = new Employee(1, null, null, null, null);
        Employee employee = employeeService.getOne(employeeCondition);
        System.out.println("employee = " + employee);
    }

    @Test
    public void testSelectByPrimaryKey(){
        Integer empId = 1;
        Employee employee = employeeService.getEmployeeById(empId);
        System.out.println(employee);
    }

    @Test
    public void testExistWithPrimaryKey(){
       boolean isExists= employeeService.isExists(7);
        System.out.println(isExists);
    }

    @Test
    public void testInsert(){
        Employee employee = new Employee(null, "Tom3", "M", "Tom3@qq.com", 1);
        employeeService.saveEmployee(employee);
        //获取employee的主键id
        Integer  empId= employee.getEmpId();
        System.out.println("empId = " + empId);
    }

    @Test
    public void testInsertSelective(){
        Employee employee = new Employee(null, "Tom4", "M", "Tom4@qq.com", null);
        employeeService.saveEmployeeSelective(employee);

    }

    @Test
    public void testUpdateByPrimaryKey(){


    }

    @Test
    public void testUpdateByPrimaryKeySelective(){
        Employee employee = new Employee(1039, null, null, null, 1);
        employeeService.updateEmployeeSelective(employee);

    }

    @Test
    public void testDelete(){


    }

    @Test
    public void testDeleteByPrimaryKey(){
        Integer empId = 1024;
        employeeService.deleteEmployeeByPrimaryKey(empId);
    }

    @Test
    public void testSelectByExample(){

        // 1.创建Example对象
        Example example = new Example(Employee.class);
        // 2.通过Example对象创建Criteria对象
        Example.Criteria criteria01 = example.createCriteria();
        Example.Criteria criteria02 = example.createCriteria();

        //设置排序
        example.orderBy("empId").desc();
        //设置去重
        example.setDistinct(true);
        //设置select字段
        example.selectProperties("empId","empName");

        // 3.在两个Criteria对象中分别设置查询条件
        criteria01.andGreaterThan("empId",1000).andGreaterThan("dId",1);
        criteria02.andGreaterThan("empId",500).andGreaterThan("dId",1);
        //使用or关键词组装两个Criteria对象
        example.or(criteria02);
        //执行查询
        List<Employee> empList = employeeService.getEmpListByExample(example);
        for (Employee employee : empList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testSelectByRowBounds(){

//        int pageNo = 3;
//        int pageSize = 5;
//        int index = (pageNo - 1)*pageSize;
//        RowBounds rowBounds = new RowBounds(index, pageSize);
//        List<Employee> empList=employeeService.getEmpListByRowBounds(rowBounds);
    }

    @Test
    public void testSelectOneByExample(){


    }

    @Test
    public void testSelectCountByExample(){


    }

    @Test
    public void testDeleteByExample(){


    }
    @Test
    public void testGetEmpList(){
        PageHelper.startPage(1,10);
        List<Employee> list= employeeService.getEmpList();
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        System.out.println("pageInfo = " + pageInfo);
    }

    @Test
    public void getEmpList(){
        PageHelper.startPage(1,10);
        List<Employee> list= employeeService.getEmpList();
        PageInfo<Employee> pageInfo = new PageInfo<>(list);
        System.out.println("pageInfo = " + pageInfo);
    }

}

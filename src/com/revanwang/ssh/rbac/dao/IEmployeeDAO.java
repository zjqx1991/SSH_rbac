package com.revanwang.ssh.rbac.dao;

import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;
import com.revanwang.ssh.rbac.query.PageResult;

import java.util.List;

public interface IEmployeeDAO extends IGenericDAO<Employee> {

    /**
     * 封装Employee的高级查询
     * @param qo 高级查询对象
     * @return  查询的数据
     */
    List<Employee> query(EmployeeQueryObject qo);


    /**
     * @param currentPage   当前页
     * @param pageSize      每页个数
     * @return  分页查询结果对象
     */
    PageResult queryPage1(int currentPage, int pageSize);


    /**
     * @param qo 封装Employee的高级查询和分页查询信息
     * @return  分页查询结果
     */
    PageResult queryPage(EmployeeQueryObject qo);
}

package com.revanwang.ssh.rbac.dao;

import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;
import com.revanwang.ssh.rbac.query.PageResult;


public interface IEmployeeDAO extends IGenericDAO<Employee> {
    /**
     * 封装 高级查询 + 分页查询
     * @param qo 查询对象信息
     * @return  分页查询结果
     */
    PageResult query(EmployeeQueryObject qo);
}

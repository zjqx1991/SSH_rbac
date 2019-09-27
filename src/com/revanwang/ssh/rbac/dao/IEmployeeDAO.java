package com.revanwang.ssh.rbac.dao;

import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;

import java.util.List;

public interface IEmployeeDAO extends IGenericDAO<Employee> {

    /**
     * 封装Employee的高级查询
     * @param qo 高级查询对象
     * @return  查询的数据
     */
    List<Employee> query(EmployeeQueryObject qo);
}

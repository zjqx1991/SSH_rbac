package com.revanwang.ssh.rbac.service;

import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.abstractQueryObject;
import com.revanwang.ssh.rbac.query.QueryResult;

import java.util.List;

public interface IEmployeeService {

    void save(Employee e);

    void delete(Long id);

    void update(Employee e);

    Employee get(Long id);

    List<Employee> getList();

    /**
     * 封装 高级查询 + 分页查询
     * @param qo 查询对象信息
     * @return  分页查询结果
     */
    QueryResult query(abstractQueryObject qo);
}

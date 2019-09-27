package com.revanwang.ssh.rbac.service;

import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;

import java.util.List;

public interface IEmployeeService {

    void save(Employee e);

    void delete(Long id);

    void update(Employee e);

    Employee get(Long id);

    List<Employee> getList();

    List<Employee> query(EmployeeQueryObject qo);
}

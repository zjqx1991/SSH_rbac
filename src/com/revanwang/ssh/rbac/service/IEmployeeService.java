package com.revanwang.ssh.rbac.service;

import com.revanwang.ssh.rbac.domain.Employee;

import java.util.List;

public interface IEmployeeService {

    void save(Employee e);

    void delete(Employee e);

    void update(Employee e);

    Employee get(Long id);

    List<Employee> getList();
}

package com.revanwang.ssh.rbac.dao;

import com.revanwang.ssh.rbac.domain.Employee;

import java.util.List;

public interface IEmployeeDAO {

    void save(Employee e);

    void delete(Employee e);

    void update(Employee e);

    Employee get(Long id);

    List<Employee> getList();
}

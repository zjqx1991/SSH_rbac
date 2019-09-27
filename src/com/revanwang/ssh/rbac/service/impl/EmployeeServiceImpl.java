package com.revanwang.ssh.rbac.service.impl;

import com.revanwang.ssh.rbac.dao.IEmployeeDAO;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.service.IEmployeeService;
import lombok.Setter;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    @Setter
    private IEmployeeDAO employeeDAO;

    @Override
    public void save(Employee e) {
        this.employeeDAO.save(e);
    }

    @Override
    public void delete(Long id) {
        this.employeeDAO.delete(id);
    }

    @Override
    public void update(Employee e) {
        this.employeeDAO.update(e);
    }

    @Override
    public Employee get(Long id) {
        return this.employeeDAO.get(id);
    }

    @Override
    public List<Employee> getList() {
        return this.employeeDAO.getList();
    }
}

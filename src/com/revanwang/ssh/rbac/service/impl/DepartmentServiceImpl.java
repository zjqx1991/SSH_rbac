package com.revanwang.ssh.rbac.service.impl;

import com.revanwang.ssh.rbac.dao.IDepartmentDAO;
import com.revanwang.ssh.rbac.dao.IEmployeeDAO;
import com.revanwang.ssh.rbac.domain.Department;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.service.IDepartmentService;
import com.revanwang.ssh.rbac.service.IEmployeeService;
import lombok.Setter;

import java.util.List;

public class DepartmentServiceImpl implements IDepartmentService {

    @Setter
    private IDepartmentDAO departmentDAO;

    @Override
    public void save(Department d) {
        this.departmentDAO.save(d);
    }

    @Override
    public void delete(Long id) {
        this.departmentDAO.delete(id);
    }

    @Override
    public void update(Department d) {
        this.departmentDAO.update(d);
    }

    @Override
    public Department get(Long id) {
        return this.departmentDAO.get(id);
    }

    @Override
    public List<Department> getList() {
        return this.departmentDAO.getList();
    }
}

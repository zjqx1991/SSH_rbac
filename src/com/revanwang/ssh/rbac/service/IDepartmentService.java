package com.revanwang.ssh.rbac.service;


import com.revanwang.ssh.rbac.domain.Department;

import java.util.List;

public interface IDepartmentService {

    void save(Department d);

    void delete(Department d);

    void update(Department d);

    Department get(Long id);

    List<Department> getList();
}

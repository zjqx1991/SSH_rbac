package com.revanwang.ssh.rbac.dao;


import com.revanwang.ssh.rbac.domain.Department;

import java.util.List;

public interface IDepartmentDAO {

    void save(Department d);

    void delete(Department d);

    void update(Department d);

    Department get(Long id);

    List<Department> getList();
}

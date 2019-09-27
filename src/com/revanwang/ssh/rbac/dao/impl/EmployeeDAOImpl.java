package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IEmployeeDAO;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;
import org.hibernate.Query;

import java.util.List;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {

    @Override
    public List<Employee> query(EmployeeQueryObject qo) {
        //高级查询条件
        String hql = "SELECT obj FROM Employee obj" + qo.getQueryCondition();
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        //高级查询设置参数
        List<Object> params = qo.getQueryParams();
        for (int i = 0; i < params.size(); i++) {
            query.setParameter(i, params.get(i));
        }
        return query.list();
    }
}

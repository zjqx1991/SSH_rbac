package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IEmployeeDAO;
import com.revanwang.ssh.rbac.domain.Employee;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class EmployeeDAOImpl implements IEmployeeDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Employee e) {
        this.sessionFactory.getCurrentSession().persist(e);
    }

    @Override
    public void delete(Employee e) {
        this.sessionFactory.getCurrentSession().delete(e);
    }

    @Override
    public void update(Employee e) {
        this.sessionFactory.getCurrentSession().update(e);
    }

    @Override
    public Employee get(Long id) {
        return (Employee) this.sessionFactory.getCurrentSession().load(Employee.class, id);
    }

    @Override
    public List<Employee> getList() {
        String hql = "SELECT e FROM Employee e";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}

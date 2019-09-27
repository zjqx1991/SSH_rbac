package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IDepartmentDAO;
import com.revanwang.ssh.rbac.domain.Department;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.util.List;

public class DepartmentDAOImpl implements IDepartmentDAO {


    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void save(Department d) {
        this.sessionFactory.getCurrentSession().persist(d);
    }

    @Override
    public void delete(Department d) {
        this.sessionFactory.getCurrentSession().delete(d);
    }

    @Override
    public void update(Department d) {
        this.sessionFactory.getCurrentSession().update(d);
    }

    @Override
    public Department get(Long id) {
        return (Department) this.sessionFactory.getCurrentSession().load(Department.class, id);
    }

    @Override
    public List<Department> getList() {
        String hql = "SELECT d FROM Department d";
        Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }
}

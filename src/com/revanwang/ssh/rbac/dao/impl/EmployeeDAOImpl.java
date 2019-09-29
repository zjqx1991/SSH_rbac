package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IEmployeeDAO;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;
import com.revanwang.ssh.rbac.query.PageResult;
import org.hibernate.Query;

import java.util.Collections;
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

    @Override
    public PageResult queryPage1(int currentPage, int pageSize) {
        //查询总个数
        String countHql = "SELECT COUNT(obj) FROM Employee obj";
        int totalCount = (int) sessionFactory.getCurrentSession().createQuery(countHql).uniqueResult();
        if (totalCount == 0) {
            return PageResult.empty();
        }

        //查询所以记录
        String resultHql = "SELECT obj FROM Employee obj";
        Query query = sessionFactory.getCurrentSession().createQuery(resultHql);
        System.out.println("EmployeeDAOImpl.queryPage:" + currentPage + ":__:" + pageSize);
        if (currentPage > 0 && pageSize > 0) {
            query.setFirstResult(Math.toIntExact((currentPage - 1) * pageSize))
                    .setMaxResults(Math.toIntExact(pageSize));
        }
        List<Employee> resultList = query.list();

        return new PageResult(totalCount, resultList, currentPage, pageSize);
    }

    @Override
    public PageResult queryPage(EmployeeQueryObject qo) {
        int currentPage = qo.getCurrentPage();
        int pageSize    = qo.getPageSize();
        //查询总个数
        String countHql = "SELECT COUNT(obj) FROM Employee obj";
        int totalCount = ((Long)sessionFactory.getCurrentSession().createQuery(countHql).uniqueResult()).intValue();
        if (totalCount == 0) {
            return PageResult.empty();
        }

        //查询所以记录
        String resultHql = "SELECT obj FROM Employee obj";
        Query query = sessionFactory.getCurrentSession().createQuery(resultHql);
        System.out.println("EmployeeDAOImpl.queryPage:" + currentPage + ":__:" + pageSize);
        if (currentPage > 0 && pageSize > 0) {
            query.setFirstResult((currentPage - 1) * pageSize)
                    .setMaxResults(pageSize);
        }
        List<Employee> resultList = query.list();

        return new PageResult(totalCount, resultList, currentPage, pageSize);
    }
}

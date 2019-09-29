package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IEmployeeDAO;
import com.revanwang.ssh.rbac.domain.Employee;
import com.revanwang.ssh.rbac.query.EmployeeQueryObject;
import com.revanwang.ssh.rbac.query.PageResult;
import org.hibernate.Query;

import java.util.List;

public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {

    @Override
    public PageResult query(EmployeeQueryObject qo) {
        int currentPage = qo.getCurrentPage();
        int pageSize    = qo.getPageSize();
        //查询总个数
        String countHql = "SELECT COUNT(obj) FROM Employee obj" + qo.getQueryCondition();
        Query countQuery = sessionFactory.getCurrentSession().createQuery(countHql);
        //给SQL语句占位符设值
        setupQueryParam(qo, countQuery);

        int totalCount = ((Long)countQuery.uniqueResult()).intValue();
        if (totalCount == 0) {
            return PageResult.empty();
        }

        //查询所以记录
        String resultHql = "SELECT obj FROM Employee obj" + qo.getQueryCondition();
        Query query = sessionFactory.getCurrentSession().createQuery(resultHql);
        //给SQL语句占位符设值
        setupQueryParam(qo, query);
        if (currentPage > 0 && pageSize > 0) {
            query.setFirstResult((currentPage - 1) * pageSize)
                    .setMaxResults(pageSize);
        }
        List<Employee> resultList = query.list();

        return new PageResult(totalCount, resultList, currentPage, pageSize);
    }

    /**
     * 为SQL语句参数赋值
     * @param qo 查询对象
     * @param query
     */
    private void setupQueryParam(EmployeeQueryObject qo, Query query) {
        for (int i = 0; i < qo.getQueryParams().size(); i++) {
            query.setParameter(i, qo.getQueryParams().get(i));
        }
    }
}

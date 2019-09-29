package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IGenericDAO;
import com.revanwang.ssh.rbac.query.abstractQueryObject;
import com.revanwang.ssh.rbac.query.QueryResult;
import org.hibernate.Query;
import org.hibernate.SessionFactory;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 封装增删改查DAO实现类
 * @param <T> 对象类型
 */
public class GenericDAOImpl<T> implements IGenericDAO<T> {

    protected SessionFactory sessionFactory;
    private Class<T> targetClass;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public GenericDAOImpl() {
        //获取this的 带有泛型信息的父类
        ParameterizedType clz = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取泛型父类中泛型参数
        Type[] types = clz.getActualTypeArguments();
        targetClass = (Class<T>) types[0];
    }


    @Override
    public void save(T obj) {
        sessionFactory.getCurrentSession().persist(obj);
    }

    @Override
    public void delete(Long id) {
        T obj = get(id);
        sessionFactory.getCurrentSession().delete(obj);
    }

    @Override
    public void update(T obj) {
        sessionFactory.getCurrentSession().update(obj);
    }

    @Override
    public T get(Long id) {
        return (T) sessionFactory.getCurrentSession().get(targetClass, id);
    }

    @Override
    public List<T> getList() {
        return sessionFactory.getCurrentSession().createCriteria(targetClass).list();
    }


    @Override
    public QueryResult query(abstractQueryObject qo) {
        int currentPage = qo.getCurrentPage();
        int pageSize    = qo.getPageSize();
        //查询总个数
        String countHql = "SELECT COUNT(obj) FROM " + targetClass.getSimpleName() + " obj" + qo.getQueryCondition();
        Query countQuery = sessionFactory.getCurrentSession().createQuery(countHql);
        //给SQL语句占位符设值
        setupQueryParam(qo, countQuery);

        int totalCount = ((Long)countQuery.uniqueResult()).intValue();
        if (totalCount == 0) {
            return QueryResult.empty();
        }

        //查询所以记录
        String resultHql = "SELECT obj FROM " + targetClass.getSimpleName() + " obj" + qo.getQueryCondition();
        Query query = sessionFactory.getCurrentSession().createQuery(resultHql);
        //给SQL语句占位符设值
        setupQueryParam(qo, query);
        if (currentPage > 0 && pageSize > 0) {
            query.setFirstResult((currentPage - 1) * pageSize)
                    .setMaxResults(pageSize);
        }
        List<T> resultList = query.list();

        return new QueryResult(totalCount, resultList, currentPage, pageSize);
    }

    /**
     * 为SQL语句参数赋值
     * @param qo 查询对象
     * @param query
     */
    private void setupQueryParam(abstractQueryObject qo, Query query) {
        for (int i = 0; i < qo.getQueryParams().size(); i++) {
            query.setParameter(i, qo.getQueryParams().get(i));
        }
    }
}

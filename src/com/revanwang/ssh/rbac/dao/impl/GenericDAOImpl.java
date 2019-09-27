package com.revanwang.ssh.rbac.dao.impl;

import com.revanwang.ssh.rbac.dao.IGenericDAO;
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
}

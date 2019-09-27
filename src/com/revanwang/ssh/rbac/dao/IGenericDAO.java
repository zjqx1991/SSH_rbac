package com.revanwang.ssh.rbac.dao;


import java.util.List;

/**
 * 封装 增删改查 DAO接口
 * @param <T>   对象类型
 */
public interface IGenericDAO<T> {

    void save(T obj);

    void delete(Long id);

    void update(T obj);

    T get(Long id);

    List<T> getList();

}

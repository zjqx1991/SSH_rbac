package com.revanwang.ssh.rbac.dao;


import com.revanwang.ssh.rbac.query.QueryResult;
import com.revanwang.ssh.rbac.query.abstractQueryObject;

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

    /**
     * 封装 高级查询 + 分页查询
     * @param qo 查询对象信息
     * @return  分页查询结果
     */
    QueryResult query(abstractQueryObject qo);

}

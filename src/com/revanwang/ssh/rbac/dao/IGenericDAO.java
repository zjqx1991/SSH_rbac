package com.revanwang.ssh.rbac.dao;


import java.util.List;

public interface IGenericDAO<T> {

    void save(T obj);

    void delete(Long id);

    void update(T obj);

    T get(Long id);

    List<T> getList();

}

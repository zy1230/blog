package com.sys.dao;

import com.sys.bean.BaseBean;

import java.util.List;

public interface BaseDao<E extends BaseBean> {
    E findById(String id);
    List<E> findList(E e);
    List<E> findAll();
    void insert(E e);
    void update(E e);
    void delete(String id);
    void delete(E e);
    E findByTitle(String title);

}

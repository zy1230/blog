package com.sys.service;

import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sys.bean.BaseBean;
import com.sys.dao.BaseDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class BaseSevice<D extends BaseDao<E>,E extends BaseBean> {

    @Autowired
    private D dao;

    public PageInfo<E> page(Integer pageNum, Integer pageSize, final E condition){
        pageNum = pageNum!=null?pageNum:1;
        pageSize = pageSize!=null?pageSize:5;
        PageInfo<E> pageInfo = PageHelper.startPage(pageNum,pageSize)
                .doSelectPageInfo(
                        new ISelect() {
                            public void doSelect() {
                                List<E> list;
                                list = dao.findList(condition);

                            }
                        }
                );
        return pageInfo;

    }
    public E findById(String id){
        return dao.findById(id);
    }
    public List<E> findList(E e){
        return dao.findList(e);
    }
    public List<E> findAll(){
        return dao.findAll();
    }
    public void delete(String id){
        dao.delete(id);
    }
    public void delete(E e){
        dao.delete(e);
    }

    public void save(E e){
        if(StringUtils.isBlank(e.getId())){
            e.preInsert();
dao.insert(e);
        }else {
            e.preUpdate();
            dao.update(e);
        }
    }

    public void insert(E e){
        dao.insert(e);
     //   System.out.println("okkkkkkkkkkkkk");
    }

    public E findByTitle(String title){
        return dao.findByTitle(title);
    }
}

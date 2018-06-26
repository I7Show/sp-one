package com.pinyougou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinyougou.service.BaseService;
import com.pinyougou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.io.Serializable;
import java.util.List;


/**
 * Date   : 2018/6/26
 * Author : zPxiao
 * Email  : Z9Show@163.com
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    //Spring4.x版本后引入的泛型依赖注入
    @Autowired
    private Mapper<T> mapper;


    @Override
    public T findOne(Serializable id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<T> findAll() {
        return mapper.selectAll();
    }

    @Override
    public PageResult findPageByWhere(Integer page, Integer rows, T t) {
        PageHelper.startPage(page , rows);
        List<T> list = mapper.select(t);
        PageInfo<T> pageInfo = new PageInfo<>();
        return new PageResult(pageInfo.getTotal() , pageInfo.getList());
    }

    @Override
    public void add(T t) {
        mapper.insertSelective(t);
    }

    @Override
    public void update(T t) {
        mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public void deleteByIds(Serializable[] ids) {
        if(ids != null && ids.length > 0) {
            for (Serializable id : ids) {
                mapper.deleteByPrimaryKey(id);
            }
        }
    }
}

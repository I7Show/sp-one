package com.pinyougou.service;

import com.pinyougou.vo.PageResult;

import java.io.Serializable;
import java.util.List;

/**
 * Date   : 2018/6/26
 * Author : zPxiao
 * Email  : Z9Show@163.com
 */
public interface BaseService<T> {

    /**
     * 根据主键查询
     * @param id 主键
     * @return 实体对象
     */
    T findOne(Serializable id);


    /**
     * 查询全部
     * @return 实体对象集合
     */
    List<T> findAll();


    /**
     * 根据条件分页查询
     * @param t 查询条件对象
     * @param page 当前页码
     * @param rows 每页显示数量
     * @return 分页实体对象
     */
    PageResult findPageByWhere(Integer page , Integer rows ,T t);


    /**
     * 新增
     * @param t 实体对象
     */
    void add(T t);


    /**
     * 修改
     * @param t 实体对象
     */
    void update(T t);


    /**
     * 批量删除
     * @param ids 主键集合
     */
    void deleteByIds(Serializable[] ids);
}

package com.pinyougou.mapper;

import com.pinyougou.pojo.TbBrand;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * Date   : 2018/6/25
 * Author : zPxiao
 * Email  : Z9Show@163.com
 */
public interface BrandMapper extends Mapper<TbBrand> {
    List<TbBrand> queryAll();
}

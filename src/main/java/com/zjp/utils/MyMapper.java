package com.zjp.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * Mapper 提供简单的增删改查，
 * MySqlMapper 针对mysql额外提供了至此批量操作
 * @Author: zhujunpeng
 * @Date: 2018/11/21 20:31
 * @Version 1.0
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}

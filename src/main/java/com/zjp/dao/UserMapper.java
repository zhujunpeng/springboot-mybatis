package com.zjp.dao;

import com.zjp.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.zjp.bean.User;

import java.util.List;

public interface UserMapper extends MyMapper<User> {

//	User findUserById(int id);
//  在通用mapper的基础上增加配置，可以使用注解或者是xml文件配置
	@Select("select * from t_user")
	List<User> getAllUser();
}

package com.zjp.service;

import com.zjp.bean.User;
import com.zjp.utils.PageResultSet;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户操作
 */
public interface UserService {

    /**
     * 根据id获取用户
     * @param id
     * @return
     */
    User getUserById(int id);

    List<User> getUserByName(String name,int age);

    PageResultSet<User> getAllUser();

    void addUser(User user);

    void updateUser(User user);

    /**
     * QBC查询 一个criteria
     * @param name
     * @return
     */
    List<User> queryByExample1(String name);

    /**
     * QBC查询 两个criteria
     * @param name
     * @return
     */
    List<User> queryByExample2(String name,String name2);

    /**
     * QBC查询 一个criteria
     * @param user
     * @return
     */
    List<User> queryByExample3(User user);

    /**
     * 实现动态sql
     * @param username
     * @param name
     * @return
     */
    List<User> dynamicSql(String username,String name);

    /**
     * 使用weekend，防止sql的字段写错
     * @param name
     * @return
     */
    List<User> queryByWeekend(String name);
}

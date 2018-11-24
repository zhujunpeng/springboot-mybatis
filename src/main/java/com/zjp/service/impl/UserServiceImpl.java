package com.zjp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjp.bean.User;
import com.zjp.dao.UserMapper;
import com.zjp.service.UserService;
import com.zjp.utils.PageResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * 用户服务
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据通用mapper获取信息
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据指定的参数查询用户
     * @param name
     * @param age
     * @return
     */
    @Override
    public List<User> getUserByName(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        List<User> users = userMapper.select(user);
        return users;
    }

    @Override
    public PageResultSet<User> getAllUser() {
        // 分页
        PageHelper.startPage(1,2);
        List<User> users = userMapper.getAllUser();
        PageInfo pageInfo = new PageInfo(users);
        // 返回所有数量
        long total = pageInfo.getTotal();
        int pages = pageInfo.getPages();
        PageResultSet<User> pageResultSet = new PageResultSet<User>();
        pageResultSet.setRows(users);
        pageResultSet.setTotal(total);
        pageResultSet.setPageNum(pages);
//        System.out.println("total="+total);
//        System.out.println("pages="+pages);
        return pageResultSet;
    }

    /**
     * 添加用户，需要开启事务
     * @param user
     */
    @Override
    @Transactional
    public void addUser(User user) {
        userMapper.insert(user);
    }

    /**
     * 根据主键更新用户，开启事务
     * @param user
     */
    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    /**
     * 使用Criteria查询，支持模糊查询
     * 这里是传入一个
     * @param name
     * @return
     */
    @Override
    public List<User> queryByExample1(String name) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("name","%"+name+"%");
        // 传入riteria
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> queryByExample2(String name, String name2) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        Example.Criteria criteria2 = example.createCriteria();
        // 名字中包含name
        criteria.andLike("name","%"+name+"%");
        // 名字中包含name2
        criteria2.andLike("name","%"+name2+"%");
        example.or(criteria2);
        // 传入Criteria
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> queryByExample3(User user) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        // 大于某个年龄的
        criteria.andGreaterThan("age",user.getAge());
        // 排序
        example.orderBy("username").asc();
        // 选择指定的属性
        example.selectProperties("id","username","name","age");
        // 查询
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> dynamicSql(String username, String name) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)){
            criteria.andLike("username",username+"%");
        }
        if (!StringUtils.isEmpty(name)){
            criteria.andLike("name",name+"%");
        }
        return userMapper.selectByExample(example);
    }
}

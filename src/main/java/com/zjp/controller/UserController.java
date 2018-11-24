package com.zjp.controller;

import com.zjp.bean.User;
import com.zjp.service.UserService;
import com.zjp.utils.PageResultSet;
import com.zjp.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 用户控制器
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result getUserById(@PathVariable int id){
        User user = userService.getUserById(id);
        return Result.success(user);
    }

    /**
     * 获取所有的用户
     * @return
     */
    @GetMapping("/all")
    public Result getAllUser(){
        PageResultSet<User> resultSet = userService.getAllUser();
        return Result.success(resultSet);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping("/add")
    public Result addUser(@Validated @RequestBody User user){
        userService.addUser(user);
        return Result.success();
    }

    /**
     * 根据主键更新
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result UpdateUser(@RequestBody User user){
        userService.updateUser(user);
        return Result.success();
    }

    /**
     * 根据name模糊查询
     * @param name
     * @return
     */
    @GetMapping("/find/like/{name}")
    public Result fingUserike(@PathVariable String name){
        List<User> users = userService.queryByExample1(name);
        return Result.success(users);
    }

    /**
     * 实现 or 查询
     * @param name
     * @param name2
     * @return
     */
    @GetMapping("/find/like2")
    public Result findUserLike2(String name,String name2){
        List<User> users = userService.queryByExample2(name,name2);
        return Result.success(users);
    }

    /**
     * 查询后的数据排序
     * @param age
     * @return
     */
    @GetMapping("/find/order")
    public Result findUserOrder(@RequestParam int age){
        User user = new User();
        user.setAge(age);
        List<User> users = userService.queryByExample3(user);
        return Result.success(users);
    }

    /**
     * 实现动态模糊查询
     * @param username
     * @param name
     * @return
     */
    @GetMapping("find/like3")
    public Result findUser(String username,String name){
        List<User> users = userService.dynamicSql(username, name);
        return Result.success(users);
    }
}

package com.zjp.bean;

import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * 对应数据库t_user表
 * 对应数据库字段转换成驼峰模式  如果是userName就会转换为user_name
 */
@Table(name = "t_user")
public class User {

	// 标记这个字段为主键
	@Id
	// 申明字段与数据库的对应
	@Column(name = "id")
	// 根据主键查询或者更新一定要加上主键策略
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int id;
	// 指定数据库与实体类的对应字段
//	@Column(name = "username")
	@NotBlank
	private String username;
	@NotBlank
	@Size(min=2 ,max= 20 ,message = "姓名长度不符合标准")
	private String name;
	@NotNull
	private Integer age;
	private BigDecimal balance;
	// 指定这个字段不与数据库对应
	@Transient
	private String testStr;

	// 乐观锁
	@Version
	private Integer version;

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getTestStr() {
		return testStr;
	}

	public void setTestStr(String testStr) {
		this.testStr = testStr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}

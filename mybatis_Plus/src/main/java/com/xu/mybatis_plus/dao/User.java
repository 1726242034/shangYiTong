package com.xu.mybatis_plus.dao;

import com.baomidou.mybatisplus.annotation.*;

public class User {

	@TableId(type = IdType.AUTO)
	private Long id;

	private String name;

//	FieldFill.INSERT_UPDATE 添加和更新的时候自动填充数据
//	填充的操作需要自定义一个类然后实现'MetaObjectHandler'接口
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Integer age;

	private String email;

	@TableLogic
	private Integer deleted;


	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", email='" + email + '\'' +
				", deleted=" + deleted +
				'}';
	}

	public User() {
	}

	public User(Long id, String name, Integer age, String email, Integer deleted) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.email = email;
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
}

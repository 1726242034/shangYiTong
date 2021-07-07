package com.xu.mybatis_plus.dao;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/*
* MybatisPlus自动填充数据
* */
@Component
public class UserMetaObjectHandler implements MetaObjectHandler {

	/*		添加操作执行的方法
	* 当给age添加数据的时候 就会自动填充' 20 '
	* */
	@Override
	public void insertFill(MetaObject metaObject) {
		this.setFieldValByName("age",20,metaObject);
	}

//	更新操作执行的方法
	@Override
	public void updateFill(MetaObject metaObject) {
		this.setFieldValByName("age",20,metaObject);
	}
}

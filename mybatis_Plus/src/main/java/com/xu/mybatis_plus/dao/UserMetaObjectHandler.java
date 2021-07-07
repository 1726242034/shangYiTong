package com.xu.mybatis_plus.dao;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

@Component
public class UserMetaObjectHandler implements MetaObjectHandler {

//	添加操作执行的方法
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

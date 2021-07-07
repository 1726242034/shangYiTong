package com.xu.mybatis_plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xu.mybatis_plus.dao.User;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface UserMapper extends BaseMapper<User> {

}

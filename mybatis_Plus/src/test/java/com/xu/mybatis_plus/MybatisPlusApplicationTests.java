package com.xu.mybatis_plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xu.mybatis_plus.dao.User;
import com.xu.mybatis_plus.dao.UserPage;
import com.xu.mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

	@Autowired
	private UserMapper userMapper;

	@Test
	void contextLoads() {
//		=================================================================添加数据
		User user = new User(){{
			setName("Lian");
//			setAge(20);
			setEmail("1726242034@qq.com");
		}};
//		userMapper.insert(user);


//		=================================================================全部查询
		List<User> users = userMapper.selectList(null);
//		System.out.println(users);

//		=================================================================分页查询
		Page<User> userPage = userMapper.selectPage(
				new Page<>(1, 3),
				new QueryWrapper<>(user).eq("id", 1));

//		userPage.hasPrevious();	// 上一页
//		userPage.hasNext();		// 下一页
//		userPage.getCurrent();	// 当前页
//		userPage.getPages();	// 总页数
//		userPage.getTotal();	// 总记录
//		System.out.println(userPage.getCurrent());


	}

}

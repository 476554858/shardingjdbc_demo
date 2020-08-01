package com.zjx.shardingjdbc_demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjx.shardingjdbc_demo.bean.Course;
import com.zjx.shardingjdbc_demo.bean.Udict;
import com.zjx.shardingjdbc_demo.bean.User;
import com.zjx.shardingjdbc_demo.mapper.CourseMapper;
import com.zjx.shardingjdbc_demo.mapper.UdictMapper;
import com.zjx.shardingjdbc_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ShardingjdbcDemoApplicationTests {

	@Autowired
	CourseMapper courseMapper;

	@Autowired
	UserMapper userMapper;

	@Autowired
	UdictMapper udictMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void addCount(){
		for (int i = 0; i < 10; i++) {
			Course course = new Course();
			course.setCname("java");
			course.setUserId(1l);
			course.setCsstatus("free");
			courseMapper.insert(course);
		}
	}

	@Test
	public void find(){
		List<Course> list = courseMapper.selectList(new EntityWrapper<Course>().isNotNull("cid"));
        System.out.println(list.size());
	}

	@Test
	public void testAddDB(){
		Course course = new Course();
		course.setCname("java");
		course.setUserId(1L);
		course.setCsstatus("free");
		courseMapper.insert(course);
	}

	//测试添加user
	@Test
	public void test1(){
		User user = new User();
		user.setUsername("zx");
		user.setUstatus("1");
		userMapper.insert(user);
	}

	//测试查询 user
	@Test
	public void test2(){
		User user = userMapper.selectById(496322858889248769L);
		System.out.println(user.toString());
	}

	//测试公共表查询
	@Test
	public void test3(){
		Udict udict = new Udict();
		udict.setUstatus("1");
		udict.setUvalue("xxx");
		udictMapper.insert(udict);
	}

	@Test
	public void test4(){
		udictMapper.deleteById(496434207942246401L);
	}

}

package com.zjx.shardingjdbc_demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjx.shardingjdbc_demo.bean.Course;
import com.zjx.shardingjdbc_demo.bean.Udict;
import com.zjx.shardingjdbc_demo.bean.User;
import com.zjx.shardingjdbc_demo.mapper.CourseMapper;
import com.zjx.shardingjdbc_demo.mapper.UdictMapper;
import com.zjx.shardingjdbc_demo.mapper.UserMapper;
import com.zjx.shardingjdbc_demo.service.CourseService;
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

//	@Autowired
//	CourseService courseService;

	@Test
	void contextLoads() {
	}

	//测试水平分库
	@Test
	public void addCourseDb(){
		Course course = new Course();
		course.setCname("javademo");
		//分库根据user_id
		course.setUserId(100L);
		course.setCsstatus("normal");
		courseMapper.insert(course);
	}

	//测试水平分库
	@Test
	public void findCourseDb(){
		Course course = new Course();
		course.setUserId(101L);
		course.setCid(661265621417197569L);
		Course course1 = courseMapper.selectOne(course);
		System.out.println(course1);
	}

	//测试水平分表
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


	//测试水平分表
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

	//测试垂直分库
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
		User user = userMapper.selectById(1456232234569699329L);
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
		udictMapper.deleteById(496434769358225409L);
	}

	//公共表测试查询
	@Test
	public void queryUdict(){
		Udict udict = new Udict();
		udict.setDictid(1454398192027287553L);
		Udict udict1 = udictMapper.selectOne(udict);
		System.out.println(udict1);
	}

//	@Test
//	public void testXA(){
//		courseService.testXATranscation();
//	}


}
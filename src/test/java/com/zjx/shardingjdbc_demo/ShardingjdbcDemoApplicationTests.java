package com.zjx.shardingjdbc_demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.zjx.shardingjdbc_demo.bean.Course;
import com.zjx.shardingjdbc_demo.mapper.CourseMapper;
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

}

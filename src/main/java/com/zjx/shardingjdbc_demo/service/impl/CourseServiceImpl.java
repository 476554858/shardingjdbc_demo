package com.zjx.shardingjdbc_demo.service.impl;

import com.zjx.shardingjdbc_demo.bean.Course;
import com.zjx.shardingjdbc_demo.bean.User;
import com.zjx.shardingjdbc_demo.mapper.CourseMapper;
import com.zjx.shardingjdbc_demo.mapper.UserMapper;
import com.zjx.shardingjdbc_demo.service.CourseService;
//import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CourseMapper courseMapper;

    //如果用的同一个数据库，可以直接使用local
//    @ShardingTransactionType(TransactionType.LOCAL)
//    @ShardingTransactionType(TransactionType.XA)
    @Transactional(rollbackFor = Exception.class)
    public void testXATranscation(){

        User user = new User();
        user.setUsername("testxa_user");
        user.setUstatus("ok");
        userMapper.insert(user);

        Course course = new Course();
        course.setCsstatus("ok");
        course.setCname("testxa_course");
        course.setUserId(user.getUserId());
        courseMapper.insert(course);
    }
}

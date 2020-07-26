package com.zjx.shardingjdbc_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zjx.shardingjdbc_demo.mapper")
@SpringBootApplication
public class ShardingjdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShardingjdbcDemoApplication.class, args);
	}

}

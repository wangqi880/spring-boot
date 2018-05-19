package com.j;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.j.mapper")
@EnableScheduling
public class SprngBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprngBootApplication.class, args);
	}
}

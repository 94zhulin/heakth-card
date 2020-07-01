package com.jsg.dzfbhealthcard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jsg.dzfbhealthcard.dao")
public class DzfbHealthCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DzfbHealthCardApplication.class, args);
	}

}

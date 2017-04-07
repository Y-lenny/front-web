package com.hawk.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication // same as @Configuration @EnableAutoConfiguration @ComponentScan

//扫描所有的mapper文件
//@MapperScan("com.hawk.springboot.dal.mapper") //或者在mapper上添加@mapper注解

//引入一些外部xml配置 如dubbo consume
//@ImportResource({"classpath:dubbo-comsume.xml"})

//指定properties文件位置
//@PropertySource("classpath:config-common.properties")
@ServletComponentScan
public class SpringbootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwebApplication.class, args);
	}
}

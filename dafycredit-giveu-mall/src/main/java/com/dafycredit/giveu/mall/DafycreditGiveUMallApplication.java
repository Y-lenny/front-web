package com.dafycredit.giveu.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication

//@MapperScan(basePackages = {"com.dafycredit.giveu.mall.admin.dal.mapper"})
@ServletComponentScan
public class DafycreditGiveUMallApplication {

	public static void main(String[] args) {
		SpringApplication.run(DafycreditGiveUMallApplication.class, args);
	}
}

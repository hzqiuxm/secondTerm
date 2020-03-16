package com.ziniuxiaozhu.jiemi.secondTerm;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableEncryptableProperties
public class SecondTermApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondTermApplication.class, args);
		System.out.println("server is start .......");
	}

}

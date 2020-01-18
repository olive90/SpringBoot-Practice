package com.olive.springboot.practice.practiceprojectgradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = "com.olive")
public class PracticeProjectGradleApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = 
				SpringApplication.run(PracticeProjectGradleApplication.class, args);
		
		for (String name : applicationContext.getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}

}

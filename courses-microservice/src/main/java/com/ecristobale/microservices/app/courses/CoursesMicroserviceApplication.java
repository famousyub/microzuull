package com.ecristobale.microservices.app.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CoursesMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoursesMicroserviceApplication.class, args);
	}

}

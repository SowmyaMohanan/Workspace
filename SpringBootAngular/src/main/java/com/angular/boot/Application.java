package com.angular.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.angular.boot.dao.StudentDaoImpl;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.angular.boot.controller", "com.angular.boot.dao", "com.angular.boot.repository", 
		"com.angular.boot.entity"}
				, basePackageClasses = {StudentDaoImpl.class} )
@EnableJpaRepositories("com.angular.boot.repository")
@EntityScan("com.angular.boot.entity")
public class Application extends SpringBootServletInitializer{
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        builder.sources(Application.class);
        System.out.println("Called configure method");
        return builder;
     }
		
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

package com.angular.boot.app;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.angular.boot.dao.StudentDaoImpl;

@SpringBootApplication
@ComponentScan(basePackages = {"com.angular.boot.controller", "com.angular.boot.dao", "com.angular.boot.repository", 
		"com.angular.boot.entity"}
				, basePackageClasses = {StudentDaoImpl.class} )
@EnableJpaRepositories("com.angular.boot.repository")
@EntityScan("com.angular.boot.entity")
public class Application {
	public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}

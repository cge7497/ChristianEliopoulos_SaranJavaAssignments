package com.christian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.christian.config.StudentConfig;
import com.christian.model.Employee;
import com.christian.model.Student;


@SpringBootApplication
public class SpringBootEx1Application {
    public static void main(String[] args) {
		SpringApplication.run(SpringBootEx1Application.class, args);
    }
}
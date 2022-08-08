package com.christian.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.christian.model.Student;

@Configuration
public class StudentConfig {

	@Bean
	public Student stuBean() {
		return new Student();
	}
}

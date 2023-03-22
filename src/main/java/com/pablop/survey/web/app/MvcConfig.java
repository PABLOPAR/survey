package com.pablop.survey.web.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class MvcConfig implements WebMvcConfigurer{

	@Qualifier("ExecutionTime")
	@Autowired
	private HandlerInterceptor executionTime;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		registry.addInterceptor(executionTime);
	}

}

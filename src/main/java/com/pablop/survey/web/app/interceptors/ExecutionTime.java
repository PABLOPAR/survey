package com.pablop.survey.web.app.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component("ExecutionTime")
public class ExecutionTime implements HandlerInterceptor{

//private static final Logger logger= LoggerFactory.getLogger(ExecutionTime.class);	
	
@Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

	long beginningTime = System.currentTimeMillis();
	request.setAttribute("beginningTime", beginningTime);

	return true;
}

@Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
		ModelAndView modelAndView) throws Exception {

	long endTaskTime = System.currentTimeMillis();
	long beginningTime = (Long) request.getAttribute("beginningTime");

	long spentTime = endTaskTime - beginningTime;

	if (modelAndView != null) {

		modelAndView.addObject("SpentTime", spentTime);

	}

}

	
	
	
}

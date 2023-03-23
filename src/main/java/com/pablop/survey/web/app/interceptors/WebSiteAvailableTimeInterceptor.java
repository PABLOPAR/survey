package com.pablop.survey.web.app.interceptors;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component("WebSiteAvailableTimeInterceptor")
public class WebSiteAvailableTimeInterceptor implements HandlerInterceptor{

	
	@Value("${config.website.openTime}")
	private Integer openTime;
	
	@Value("${config.website.closeTime}")
	private Integer closeTime;
	
	@Value("${text.WebSiteAvailableTimeInteceptor.welcome}")
	private String welcome;
	
	
	@Value("${text.WebSiteAvailableTimeInteceptor.openHourText}")
	private String openHourText;
	
	
	@Value("${text.WebSiteAvailableTimeInteceptor.to}")
	private String to;
	
	
	@Value("${text.WebSiteAvailableTimeInteceptor.oclock}")
	private String oclock;
	
	@Value("${text.WebSiteAvailableTimeInteceptor.ThanksVisiting}")
	private String ThanksVisiting;	
	
	
		
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Calendar calendar = Calendar.getInstance();
		int currentTime = calendar.get(Calendar.HOUR_OF_DAY);

		if (currentTime >= openTime && currentTime < closeTime) {
			StringBuilder messagge = new StringBuilder(welcome);
			messagge.append(" ");
			messagge.append(openHourText);
			messagge.append(" ");
			messagge.append(openTime);
			messagge.append(" ");
			messagge.append(to);
			messagge.append(" ");
			messagge.append(closeTime);
			messagge.append(" ");
			messagge.append(oclock);
			messagge.append(". ");
			messagge.append(ThanksVisiting);

			request.setAttribute("messagge", messagge.toString());
			return true;
		}
		return true;

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		String messagge = (String) request.getAttribute("messagge");

		if (modelAndView != null && handler instanceof HandlerMethod) {

			modelAndView.addObject("workingHours", messagge);
		}

	}
	
	
	

}

package com.pablop.survey.web.app;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
@PropertySources({@PropertySource("classpath:tests.properties")})
public class TextPropertiesConfig {

	
}

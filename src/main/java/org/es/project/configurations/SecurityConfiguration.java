package org.es.project.configurations;

import org.es.project.filters.AuthorizationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {
	@Bean
	public FilterRegistrationBean buildAuthorizationFilter() {
		
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new AuthorizationFilter());
		
		filterRegistration.addUrlPatterns("/server/pointsofsale/*");
		filterRegistration.addUrlPatterns("/server/products/*");
		
		return filterRegistration;
	}
	
}
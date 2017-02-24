package org.es.project.configurations;

import org.es.project.filters.AuthorizationFilter;
import org.es.project.util.ServerConstants;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfiguration {
	@Bean
	public FilterRegistrationBean buildAuthorizationFilter() {
		
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new AuthorizationFilter());
		
		filterRegistration.addUrlPatterns( ServerConstants.POINT_OF_SALE_REQUEST + "/*");
		filterRegistration.addUrlPatterns( ServerConstants.PRODUCT_REQUEST + "/*");
		filterRegistration.addUrlPatterns( ServerConstants.SEARCH_REQUEST + "/*");
		filterRegistration.addUrlPatterns( ServerConstants.USER_REQUEST + "/*");
		
		return filterRegistration;
	}
	
}
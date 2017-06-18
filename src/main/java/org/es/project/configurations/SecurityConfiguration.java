package org.es.project.configurations;

import org.es.project.filters.AuthorizationFilter;
import org.es.project.util.ServerConstants;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration {
	@Bean
	public FilterRegistrationBean buildAuthorizationFilter() {
		
		FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
		filterRegistration.setFilter(new AuthorizationFilter());
		
		addPointOfSaleURL(filterRegistration);
		addProductURL(filterRegistration);
		addUserURL(filterRegistration);
		
		return filterRegistration;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	private void addPointOfSaleURL(FilterRegistrationBean filterRegistration) {
		filterRegistration.addUrlPatterns( ServerConstants.POINT_OF_SALE_REQUEST + "/new");
		filterRegistration.addUrlPatterns( ServerConstants.POINT_OF_SALE_REQUEST + "/edit");
		filterRegistration.addUrlPatterns( ServerConstants.POINT_OF_SALE_REQUEST + "/delete");
		filterRegistration.addUrlPatterns( ServerConstants.POINT_OF_SALE_REQUEST + "/evaluate");
		
	}
	
	private void addProductURL(FilterRegistrationBean filterRegistration) {
		filterRegistration.addUrlPatterns( ServerConstants.PRODUCT_REQUEST + "/new");
		filterRegistration.addUrlPatterns( ServerConstants.PRODUCT_REQUEST + "/edit");
		filterRegistration.addUrlPatterns( ServerConstants.PRODUCT_REQUEST + "/delete");
		filterRegistration.addUrlPatterns( ServerConstants.PRODUCT_REQUEST + "/evaluate");
		
	}
	
	private void addUserURL(FilterRegistrationBean filterRegistration) {
		filterRegistration.addUrlPatterns( ServerConstants.USER_REQUEST + "/edit");
	}
	
}
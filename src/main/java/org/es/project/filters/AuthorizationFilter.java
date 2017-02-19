package org.es.project.filters;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.filter.GenericFilterBean;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

public class AuthorizationFilter extends GenericFilterBean {
	public static final String AUTHORIZATION_HEADER = "Authorization";
	public static final String AUTHORIZATION_TYPE = "Bearer ";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String header = httpRequest.getHeader(AUTHORIZATION_HEADER);
		
		if (header == null || !header.startsWith(AUTHORIZATION_TYPE)) {
			throw new ServletException("Token doesn't exist.");
		}
		
		String token = header.substring(AUTHORIZATION_TYPE.length());
		
		try {
			Jwts.parser().setSigningKey("bichopiruleta")
						 .parseClaimsJws(token).getBody();
		} catch(SignatureException e) {
			throw new ServletException("Invalid token.");
		}
		
		chain.doFilter(request, response);
	}

}

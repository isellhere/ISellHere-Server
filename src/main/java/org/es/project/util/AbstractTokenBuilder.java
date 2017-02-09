package org.es.project.util;

import java.util.Date;

import org.es.project.models.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AbstractTokenBuilder implements TokenBuilder{
	
	private long expirationTimeInMillis;
	private SignatureAlgorithm algorithm;
	private String tokenKey;
	
	public AbstractTokenBuilder(long expirationTimeInMillis, SignatureAlgorithm algorithm, String tokenKey) {
		this.expirationTimeInMillis = expirationTimeInMillis;
		this.algorithm = algorithm;
		this.tokenKey = tokenKey;
	}	

	@Override
	public String build(User user) {
		Date expiration = new Date(System.currentTimeMillis() + expirationTimeInMillis);
		
		String token = Jwts.builder().
			   	   	   setSubject(user.getUsername()).
			   	   	   signWith(algorithm, tokenKey).
			   	   	   setExpiration(expiration).
			   	   	   compact();
		
		return token;
	}

}

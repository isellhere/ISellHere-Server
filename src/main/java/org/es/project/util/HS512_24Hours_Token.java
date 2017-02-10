package org.es.project.util;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class HS512_24Hours_Token extends AbstractTokenBuilder{
	public static long HOURS24_TO_MILLIS = 24 * 60 * 60 * 1000; 
	public static String TOKEN_KEY = "bichopiruleta";
	
	public HS512_24Hours_Token() {
		super(HOURS24_TO_MILLIS, SignatureAlgorithm.HS512, TOKEN_KEY);
		// TODO Auto-generated constructor stub
	}

}

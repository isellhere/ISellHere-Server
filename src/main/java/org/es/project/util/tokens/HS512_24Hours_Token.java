package org.es.project.util.tokens;

import org.es.project.util.ServerConstants;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class HS512_24Hours_Token extends AbstractTokenBuilder{
	public static long HOURS24_TO_MILLIS = 24 * 60 * 60 * 1000; 
	
	public HS512_24Hours_Token() {
		super(HOURS24_TO_MILLIS, SignatureAlgorithm.HS512, ServerConstants.TOKEN_KEY);
		// TODO Auto-generated constructor stub
	}

}

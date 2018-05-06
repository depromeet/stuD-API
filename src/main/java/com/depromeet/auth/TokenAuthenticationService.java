package com.depromeet.auth;

import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	
	private static final long EXPIRATION_TIME = 864_000_000;
	private static final String SECRET = "aid12dks092j4fv";
	private static final String TOKEN_PREFIX = "Bearer";
	private static final String HEADER_STRING = "Authorization";
	
	public static void addAuthentication(HttpServletResponse response,
			String username) {
		String jwt = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET)
				.compact();
		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + jwt);
	}
	
	public static Authentication getAuthentication(HttpServletRequest request)
			throws RuntimeException {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			String username = Jwts.parser()
					.setSigningKey(SECRET)
					.parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
					.getBody()
					.getSubject();

			return username != null ?
					new UsernamePasswordAuthenticationToken(
							username, null, Collections.emptyList()) :
					null;
		}
		
		return null;
	}
}

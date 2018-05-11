package com.depromeet.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.depromeet.common.dto.ApiErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	
	private static final Log logger = LogFactory.getLog(JwtAuthenticationEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("Pre-authenticated entry point called. Rejecting access");
		}
		
		ApiErrorResponse errorResponse = new ApiErrorResponse("로그인이 필요합니다.");
		
		new ObjectMapper().writeValue(response.getOutputStream(), errorResponse);
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}

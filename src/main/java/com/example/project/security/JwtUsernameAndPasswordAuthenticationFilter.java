package com.example.project.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collections;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.example.project.config.ConfigUtils;
import com.example.project.response.TokenUserResponse;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(JwtUsernameAndPasswordAuthenticationFilter.class);
	// We use auth manager to validate the user credentials
	private AuthenticationManager authManager;

	private final ConfigUtils jwtConfig;

	public JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager, ConfigUtils jwtConfig) {
		this.authManager = authManager;
		this.jwtConfig = jwtConfig;

		// By default, UsernamePasswordAuthenticationFilter listens to "/login" path.
		// In our case, we use "/auth". So, we need to override the defaults.
		this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(jwtConfig.getUri(), "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			LOGGER.info("Get credentials from request");
			// 1. Get credentials from request
			UserCredentials creds = new ObjectMapper().readValue(request.getInputStream(), UserCredentials.class);

			// 2. Create auth object (contains credentials) which will be used by auth
			// manager
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), Collections.emptyList());

			// 3. Authentication manager authenticate the user, and use
			// UserDetialsServiceImpl::loadUserByUsername() method to load the user.
			return authManager.authenticate(authToken);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// Upon successful authentication, generate a token.
	// The 'auth' passed to successfulAuthentication() is the current authenticated
	// user.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		Long now = System.currentTimeMillis();
		
		TokenUserResponse tokenUserResponse =  (TokenUserResponse) auth.getPrincipal();
		String token = Jwts.builder().setSubject(auth.getName())
				// Convert to list of strings.
				// This is important because it affects the way we get them back in the Gateway.
				.claim("authorities",
						auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.setIssuedAt(new Date(now)).setExpiration(new Date(now + jwtConfig.getExpiration() * 1000)) // in
																											// milliseconds
				.signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes()).compact();

		tokenUserResponse.setRoles(auth.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()));
		tokenUserResponse.setAuthorization(token);

		Gson gson = new Gson();
		String jsonString = gson.toJson(tokenUserResponse);
	
		// Add token to header
		//response.addHeader(jwtConfig.getHeader(), jwtConfig.getPrefix() + token);
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(jsonString);
		out.flush();
		 
	}

	// A (temporary) class just to represent the user credentials
	private static class UserCredentials {
		private String username, password;

		public String getUsername() {
			return username;
		}

		@SuppressWarnings("unused")
		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		@SuppressWarnings("unused")
		public void setPassword(String password) {
			this.password = password;
		}
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		// TODO Auto-generated method stub
		super.unsuccessfulAuthentication(request, response, failed);
		
	}
}
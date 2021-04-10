package com.lawencon.tracking.config;

import java.io.IOException;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tracking.model.Users;
import com.lawencon.tracking.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

/**
 *
 * @author Galih Dika
 *
 */

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;
    private UserService userServices;
	
    public AuthenticationFilter(AuthenticationManager authenticationManager,
        UserService userServices) {
		this.authenticationManager = authenticationManager;
		this.userServices = userServices;
        super.setFilterProcessesUrl("/login");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		Users user = new Users();
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), Users.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return authenticationManager
            .authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {

		String username = authResult.getName();
		Users user = new Users();
		try {
          user = this.userServices.getUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		String secretKey = "NjE2OTliMjJjOWQ3YTQ5MDJjZjI5NjBhZThjOWMxNWIxMGQzMmI3Ngo";
		SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes());

		String token = Jwts.builder().signWith(key).setSubject(authResult.getName())
				.setExpiration(new Date(new Date().getTime() + 500000)).compact();

		response.setContentType("application/json");
        response.getWriter().append("{\"token\" : \"" + token + "\",").append("\"profile\" : {")
            .append("\"userId\" : \"" + user.getId() + "\",")
		.append("\"username\" : \"" + user.getUsername() + "\",")
            .append("\"roleCode\" : \"" + user.getRole().getCode() + "\"}").append("}");
	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		failed.printStackTrace();
	}
}

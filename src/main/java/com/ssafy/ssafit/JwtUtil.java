package com.ssafy.ssafit;

import java.io.UnsupportedEncodingException;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtil {
	private static final String SECRET = "SSAFIT_FINALPJT";
	
	public String createToken(String key, String value) throws UnsupportedEncodingException {
		return Jwts.builder()
				.setHeaderParam("alg", "HS256")
				.setHeaderParam("typ", "JWT")
				.claim(key, value)
				.signWith(SignatureAlgorithm.HS256, SECRET.getBytes("UTF-8"))
				.compact();
	}
	
	public Jws<Claims> isValid(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET.getBytes("UTF-8")).parseClaimsJws(token);
		return claims;
	}
}

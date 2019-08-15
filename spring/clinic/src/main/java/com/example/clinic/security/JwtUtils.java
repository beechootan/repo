// package com.example.clinic.security;

// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Date;
// import java.util.List;

// import com.example.clinic.constants.SecurityConstants;
// import com.example.clinic.entities.User;

// import
// org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jws;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import io.jsonwebtoken.security.Keys;

// /**
// * JwtUtils
// */
// public class JwtUtils {

// public static String generateJwt(Employee employee) {
// List<String> roles = new ArrayList<>();

// byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

// String subject = employee.getEmail();

// String token = Jwts.builder().signWith(Keys.hmacShaKeyFor(signingKey),
// SignatureAlgorithm.HS512)
// .setHeaderParam("typ",
// SecurityConstants.TOKEN_TYPE).setIssuer(SecurityConstants.TOKEN_ISSUER)
// .setAudience(SecurityConstants.TOKEN_AUDIENCE).setSubject(subject)
// .setExpiration(new Date(System.currentTimeMillis() + 864000000)).claim("rol",
// roles).compact();

// return token;
// }

// public static UsernamePasswordAuthenticationToken parseJwt(String token) {
// byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

// Jws<Claims> parsedToken =
// Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token);

// String email = parsedToken.getBody().getSubject();

// List<SimpleGrantedAuthority> authorities = Collections.emptyList();

// if (email != null) {
// return new UsernamePasswordAuthenticationToken(email, null, authorities);
// }

// return null;
// }
// }
package com.managmentapplication.taskmanagement.service.impl;

import com.managmentapplication.taskmanagement.data.models.Role;
import com.managmentapplication.taskmanagement.data.models.Users;
import com.managmentapplication.taskmanagement.service.ServiceInterface.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import io.jsonwebtoken.io.Decoders;
import java.util.Date;
@Service
@Slf4j
public class JwtServiceImpl implements JwtService {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long expiration;


    @Override
    public String generateToken(Users user) {
        log.info("Generated JWT Token");
        return Jwts.builder()
                .expiration(new Date(System.currentTimeMillis() +expiration))
                .issuedAt(new Date())
                .subject(user.getUsername())
                .claim("role", user.getRole().name())
                .signWith(generateCode())
                .compact();

    }

    private SecretKey generateCode(){
        byte[] decodedBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(decodedBytes);
    }

    @Override
    public boolean validateToken(String token) {
       try{
           extractClaims(token);
           return  true;

       }catch (Exception e){
           return false;
       }

    }
    @Override
    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    @Override
    public Role extractRole(String token) {
        return extractClaims(token).get("role", Role.class);
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateCode())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}

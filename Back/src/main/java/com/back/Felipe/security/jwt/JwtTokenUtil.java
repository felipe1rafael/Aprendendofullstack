package com.back.Felipe.security.jwt;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;



public class JwtTokenUtil implements Serializable {
    private static final long serialVersionUID = 1;

    static final String CLAIM_KEY_USER = "sub";
    static final String CLAIM_KEY_CREATED = "created";
    static final String CLAIM_KEY_EXPIRED = "exp";

    @Value("${jwt.secret}")
    private  String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String getUserNameFromToken(String token){
            String username;
            try {
                final Claims claims = null; //getClaimsFromToken
                username= claims.getSubject();
            } catch (Exception e) {
                username = null;
            }

        return username;
    }

}

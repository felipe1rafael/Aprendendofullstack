package com.back.Felipe.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


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
                final Claims claims = getClaimsFromToken(token);
                username= claims.getSubject();
            } catch (Exception e) {
                username = null;
            }

        return username;
    }

    public Date getExpiredDateFromTokens(String token){
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration= claims.getExpiration();
        } catch (Exception e) {
            expiration= null;
        }

        return expiration;
    }

    private Claims getClaimsFromToken(String token){
        Claims claim;

    try {

        claim = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

    }catch (Exception e){
    claim = null;
    }
    return claim;
    }

    private Boolean isTokenExperation(String token){
        final Date expiration =getExpiredDateFromTokens(token);
        return expiration.before(new Date());
    }

    public String generationTokens(UserDetails userDetails){
        Map<String , Object> claim = new HashMap<>();

        claim.put(CLAIM_KEY_USER , userDetails.getUsername());

        final Date createDate = new Date();
        claim.put(CLAIM_KEY_CREATED,createDate);

        return  doGenerateToken(claim);


    }

    private String doGenerateToken(Map<String, Object> claim){
        final Date createDate =(Date) claim.get(CLAIM_KEY_CREATED);
        final Date expirationDate = new Date(createDate.getTime()+expiration *1000);
        return  Jwts.builder()
                .setClaims(claim)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
    public Boolean canTokenBeRefreshed(String token){
        return (!isTokenExperation(token));

    }

    private String refreshedToken(String token){
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken =doGenerateToken(claims);

        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token , UserDetails userDetails){
        JwtUser  user = (JwtUser) userDetails;
        final String username = getUserNameFromToken(token);
        return (
                username.equals(user.getUsername())
                && !isTokenExperation(token)
                );
    }

}

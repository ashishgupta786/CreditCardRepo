package com.zbank.CreditCard.utility;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET = "my-secret-key";

    public String generateToken(String email) {

//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
//                .signWith(SignatureAlgorithm.HS256, SECRET)
//                .compact();
        return "";
    }


    public String extractEmail(String token) {
        //return getClaims(token).getSubject();
        return "";
    }

//    public boolean validateToken(String token) {
//        try {
//            getClaims(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    private Claims getClaims(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET)
//                .parseClaimsJws(token)
//                .getBody();
//    }
}
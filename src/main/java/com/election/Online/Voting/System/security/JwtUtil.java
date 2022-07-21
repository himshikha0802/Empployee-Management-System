package com.election.Online.Voting.System.security;

import com.election.Online.Voting.System.model.Role;
import com.election.Online.Voting.System.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUtil {

    public
     static  String getJWTToken(User user) {
        String secretKey = "mySecretKey";//kry to encrypt and decrypt

        List<String> authorities = user.getRoles()
                .stream()
                .map(Role::getName)
                .collect(Collectors.toList());

        String token = Jwts//library
                .builder()//to new gives best method
                .setId(String.valueOf(user.getId()))
                .setSubject(user.getFullName())
                .claim("authorities", authorities)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}

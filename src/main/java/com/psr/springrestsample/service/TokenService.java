package com.psr.springrestsample.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;



@Service
public class TokenService {

    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder) {
        this.encoder = encoder;
    }
    

    public String generateToken(Authentication authentication){
        Instant now = Instant.now(); //this gives current time
        String scope = authentication.getAuthorities() // reading all the authorities
                        .stream() // in a stream format
                        .map(GrantedAuthority::getAuthority) // storing in a map
                        .collect(Collectors.joining(" ")); //combing all authorities with space

        JwtClaimsSet claims = JwtClaimsSet.builder() // this obkect helps in getting token
                                .issuer("self") // who is ussing it, self means we 
                                .issuedAt(now)  // at what time it is given
                                .expiresAt(now.plus(1, ChronoUnit.HOURS)) // expiry of the token
                                .subject(authentication.getName()) // username of for which the token is getting generated
                                .claim("scope", scope)
                                .build();

        return this.encoder.encode(JwtEncoderParameters.from(claims)) // encoding is done
                    .getTokenValue();// token value is generated
        
    }
}

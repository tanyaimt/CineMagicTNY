package com.metaphorce_tny.api.CineMagicTNY.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtServiceI {
    String getToken(UserDetails userDetails);
    String getUserNameFromToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
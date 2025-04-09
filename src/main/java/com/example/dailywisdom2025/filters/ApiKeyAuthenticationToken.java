//package com.example.dailywisdom2025.filters;
//
//import org.springframework.security.authentication.AbstractAuthenticationToken;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.Collections;
//import java.util.List;
//
//public class ApiKeyAuthenticationToken extends AbstractAuthenticationToken {
//
//    private final String apiKey;
//
//    public ApiKeyAuthenticationToken(String apiKey) {
////        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
//        super(null); // No authorities initially
//        this.apiKey = apiKey;
//        setAuthenticated(true);
//
//    }
//
//    public String getApiKey() {
//        return apiKey;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return null;
//    }
//}

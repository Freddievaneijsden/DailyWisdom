//package com.example.dailywisdom2025.filters;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
////public class ApiKeyAuthenticationFilter extends OncePerRequestFilter {
////
////    @Override
////    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
////            throws ServletException, IOException {
////        String apiKey = request.getHeader("X-API-KEY");
////
////        if (isValidApiKey(apiKey)) {
////            Authentication auth = new ApiKeyAuthenticationToken(apiKey);
////            SecurityContextHolder.getContext().setAuthentication(auth); //Usable everywhere to check who's the current authorized user
////
////            filterChain.doFilter(request, response);
////        }
////    }
////
////    private boolean isValidApiKey(String apiKey) {
////        //Imlement logic here
////        return "mykey".equals(apiKey);
////    }
////}

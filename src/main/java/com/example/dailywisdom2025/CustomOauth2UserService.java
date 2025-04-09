package com.example.dailywisdom2025;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser (OAuth2UserRequest userRequest) throws OAuth2AuthenticationException
    {
        OAuth2User user = super.loadUser(userRequest);

        //Extract GitHub details
        String gitHubId = user.getAttribute("id").toString();
        String username = user.getAttribute("login");
        String email = user.getAttribute("email"); //Not available from git
        String avatarUrl = user.getAttribute("avatar_url");

        //Check if the user is in our database or if its a new user?
        //If new user add to database
        //If existing user update information
        // Check if the user exists in your local database

        List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority("ROLE_USER"));

//        System.out.println(user.getName());
//        SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getAuthorities()
//                .forEach(System.out::print);

        return new DefaultOAuth2User(authorities, user.getAttributes(), "id");
    }

}

package com.example.dailywisdom2025.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;

@Configuration
//@EnableMethodSecurity
public class SecurityConfig {

    @Bean
//    @Order(1) Multiply SecurityFilter
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .oauth2Login(Customizer.withDefaults())
//                .addFilterAfter(new ApiKeyAuthenticationFilter(), LogoutFilter.class)
//                .formLogin(Customizer.withDefaults()) //Authentication method, redirect to root /
                .authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) ->
                        authorizationManagerRequestMatcherRegistry
                                .requestMatchers("/login").permitAll()
//                                .requestMatchers("/upload").hasRole("ADMIN")
//                                .requestMatchers("/seeMessage").hasRole("ADMIN")
                                .requestMatchers("/**").authenticated()
                                .requestMatchers("/graphiql").authenticated()
//                                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui.yaml").permitAll()
//                                .requestMatchers("/api/index").hasRole("USER")
                                .anyRequest().denyAll()//Everything not listed above is denied
                        );
        return http.build();
    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//    //Never use this implementation
//    @Bean
//    UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder() //acceptable for demos but not production
//                .username("freddie")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}

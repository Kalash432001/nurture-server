package com.bal.asha.nurture.server.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfigs {

    private static final String[] AUTH_ALLOWLIST = {

            // for Swagger UI v2
            "/v2/api-docs",
            "/swagger-ui.html",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/webjars/**",

            // for Swagger UI v3 (OpenAPI)
            "/v3/api-docs/**",
            "/swagger-ui/**"
    };

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authorize) -> {
                    authorize
                        //    .requestMatchers("/h2-console/**").permitAll()
                            .anyRequest().permitAll();
                        }
                      //  .requestMatchers("/endpoint").hasAuthority('USER')
                       // .anyRequest().authenticated()
                );
        // ...
        http.headers(httpSecurityHeadersConfigurer -> httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        http.csrf(custom-> custom.disable());
        return http.build();
    }
}

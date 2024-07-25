package com.cloud_dp.pictures_microservice.config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.RequestAuthorizationContext;
import org.springframework.security.web.util.matcher.RequestMatcher;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private static final List<String> WHITELISTED_IPS = List.of("192.168.1.100", "127.0.0.1", "192.168.1.7", "0:0:0:0:0:0:0:1");

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers(new WhitelistedIpRequestMatcher("/hidden-actuator/health")).authenticated()
//                                .anyRequest().denyAll() // Deny all other requests by default
                        .anyRequest().permitAll() // Deny all other requests by default
                )
                .httpBasic(withDefaults());

        return http.build();
    }

    private static class WhitelistedIpRequestMatcher implements RequestMatcher {

        private final String path;

        public WhitelistedIpRequestMatcher(String path) {
            this.path = path;
        }

        @Override
        public boolean matches(HttpServletRequest request) {
            if (path.equalsIgnoreCase(request.getRequestURI())) {
                String remoteAddr = request.getRemoteAddr();
                return WHITELISTED_IPS.contains(remoteAddr);
            }
            return false;
        }
    }
}


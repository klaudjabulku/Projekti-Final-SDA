package com.sda.Final.Project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf(AbstractHttpConfigurer ::disable)
                .authorizeHttpRequests(authorise ->{
            authorise.requestMatchers(antMatcher(HttpMethod.GET , "/user")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/user/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/user/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT, "/user/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE, "/user/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/client")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/client/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/client/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT , "/client/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE , "/client/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/meeting")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/meeting/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/meeting/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT , "/meeting/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE , "/meeting/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/notification")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/notification/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/notification/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT , "/notification/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE , "/notification/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/socialMedia")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/socialMedia/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/socialMedia/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT , "/socialMedia/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE , "/socialMedia/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/company")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT , "/company/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE , "/company/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/company")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/company/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.POST , "/payment")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/payment")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.GET , "/payment/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.PUT , "/payment/**")).permitAll()
                    .requestMatchers(antMatcher(HttpMethod.DELETE , "/payment/**")).permitAll()
                    .anyRequest().authenticated();
        })
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}

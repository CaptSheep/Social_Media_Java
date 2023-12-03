package com.example.social_media.security;


import com.example.social_media.security.jwt.CustomAccessDeniedHandler;
import com.example.social_media.security.jwt.JwtAuthenticationFilter;
import com.example.social_media.security.jwt.RestAuthenticationEntryPoint;
import com.example.social_media.service.UserService;
import com.example.social_media.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }


    @Autowired
    private UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/login", "/register").permitAll())
                .authorizeHttpRequests(requests -> requests.requestMatchers("/posts/**").authenticated())
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .httpBasic(Customizer.withDefaults())
                .build();
//        return http.httpBasic().authenticationEntryPoint(restServicesEntryPoint())
//                .and().csrf()
//
//                .disable().authorizeRequests()
//                .requestMatchers("/login", "/register", "/hello").permitAll()
//                .requestMatchers("/users/**").access("hasRole('ROLE_USER')")
//                .requestMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
////                .requestMatchers(HttpMethod.GET).access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
////                .requestMatchers(HttpMethod.DELETE, "/categories",
////                        "/typeOfQuestions",
////                        "/questions",
////                        "/answers",
////                        "/quizzes",
////                        "/hello").access("hasRole('ROLE_ADMIN')")
////                .requestMatchers(HttpMethod.PUT, "/users")
////                .access("hasRole('ROLE_USER')")
//                .anyRequest().authenticated().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .and().addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler())
//                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().cors()
//                .and().build();
    }
}
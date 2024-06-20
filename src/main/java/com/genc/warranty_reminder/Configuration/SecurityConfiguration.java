package com.genc.warranty_reminder.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean

    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> {
                    requests.requestMatchers("/api/userRegistration", "/getUserRegistration").authenticated()
                            .anyRequest().permitAll(); // Allow unauthenticated access to other endpoints
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return (SecurityFilterChain)http.build();
    }

//    @Bean
//    public InMemoryUserDetailsManager UserService()
//    {
//        UserDetails admin= User.withUsername("Tapta").password("HelloTapta").authorities("admin").build();
//        UserDetails user1= User.withUsername("Prince").password("HelloPrince").authorities("read").build();
//        UserDetails user2= User.withUsername("Ritika").password("HelloRitika").authorities("read").build();
//        return new InMemoryUserDetailsManager(admin,user1,user2);
//
//    }
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }


}

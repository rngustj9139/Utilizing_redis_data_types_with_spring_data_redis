package koo.spring_data_redis_utilization.loginSession.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        return bCryptPasswordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors((corsConfig) ->
                    corsConfig.disable()
                )
                .csrf((csrfConfig) ->
                    csrfConfig.disable()
                )
                .headers((headerConfig) ->
                    headerConfig.frameOptions(frameOptionsConfig ->
                        frameOptionsConfig.disable()
                    )
                )
                .formLogin((formLogin) ->
                    formLogin.disable()
                );

        return http.build();
    }

}

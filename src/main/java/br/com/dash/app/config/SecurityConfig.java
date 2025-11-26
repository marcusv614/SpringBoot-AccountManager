package br.com.dash.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()) // libera POST/PUT/DELETE
				.authorizeHttpRequests(auth -> auth.anyRequest().permitAll() // libera tudo
				).formLogin(login -> login.disable()) // desativa login padrão
				.httpBasic(basic -> basic.disable()); // desativa basic auth

		return http.build();
	}
}

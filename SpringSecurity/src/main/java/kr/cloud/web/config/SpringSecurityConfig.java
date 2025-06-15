package kr.cloud.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// http.cors((cors) -> cors.disable());
		
		// CORS : 동일 출처 정책
		// CSRF : Cross site Request Forgery (사이트간 위조 요청)
		
		/*
		 * 권한 설정 시 사용가능한 Method
		 * 1) permitAll() : 모든 접근 허용
		 * 2) authenticated() : 인증된 사용자만 접근 허용
		 * 3) hasRole("권한, 역할") : 특정 역할 사용자만 접근 허용
		 * 포워드 방식으로 이동한 요청은 인증없이 이동 허용!
		 */
		http.cors(AbstractHttpConfigurer :: disable)
		.csrf(AbstractHttpConfigurer :: disable)
		.authorizeHttpRequests((request) 
				-> request.dispatcherTypeMatchers(DispatcherType.FORWARD)
				.permitAll()
				.anyRequest().authenticated())
				.formLogin((logininfo -> logininfo.loginPage("/")
						.loginProcessingUrl("/login-process")
						.usernameParameter("userid")
						.passwordParameter("userpw")
						.defaultSuccessUrl("/temp").permitAll()
						);
		return http.build();
	}

}

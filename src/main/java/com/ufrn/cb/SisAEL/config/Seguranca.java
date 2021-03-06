package com.ufrn.cb.SisAEL.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class Seguranca extends WebSecurityConfigurerAdapter{
	
	
	@Autowired
	UserDetailsServiceImpl serviceDetails;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable();
		http.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
		.and()
		.authorizeRequests()
		.antMatchers("/auth/logout","/pesquisadores/cadastrar").permitAll()
		.anyRequest().authenticated()
		.and()
		.logout().logoutUrl("auth/logout")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID");
		
		
	}
		
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
		
		auth.userDetailsService(serviceDetails);
		
}
	
	@Bean
	public PasswordEncoder encoder() {
		BCryptPasswordEncoder encod = new BCryptPasswordEncoder();
		return encod;
	}
	
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET",
                        		"PUT", "POST", "DELETE", "PATCH");
            }
        };
    }
	

}

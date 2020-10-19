
//HTTP Basic Authentication using Spring Security
package com.bmart.shopping.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.bmart.shopping.usermgmt.repository.UserRepository;
import com.bmart.shopping.usermgmt.service.UserPrincipleService;

@Configuration
@EnableWebSecurity
public class SecurityConfriguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserPrincipleService userPrincipleService;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * auth.inMemoryAuthentication()
		 * .withUser("superadmin").password(passwordEncoder().encode("superadmin123")).
		 * roles("SUPERADMIN").authorities("ACCESS_TEST2","ROLE_SUPERADMIN") .and()
		 * .withUser("admin").password(passwordEncoder().encode("admin123")).roles(
		 * "ADMIN").authorities("ACCESS_TEST1","ACCESS_TEST2","ROLE_ADMIN") .and()
		 * .withUser("dan").password(passwordEncoder().encode("dan123")).roles("USER");
		 */		
		
		auth.authenticationProvider(this.authenticationProvider());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .authorizeRequests()
		 * .antMatchers("/user/test1").hasAuthority("ACCESS_TEST1")
		 * .antMatchers("/user/test2").hasAuthority("ACCESS_TEST2") .and() .httpBasic();
		 */
		
		
		
		http
        .csrf().disable() /* remove csrf and state in session because in jwt we do not need them */
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationManager()))/* add jwt filters (1. authentication, 2. authorization) */
        .addFilter(new JwtAuthorizationFilter(authenticationManager(),  this.userRepository))
        .authorizeRequests()/* configure access rules */
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers("/usermgmt/users/*").hasRole("SUPERADMIN")
        .antMatchers("/usermgmt/test1/*").hasRole("ADMIN")
        .anyRequest().authenticated();
		
	}
	
	@Bean
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider= new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.userPrincipleService);
		return daoAuthenticationProvider;
	}
	
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

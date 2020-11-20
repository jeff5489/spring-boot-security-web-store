package com.example.thymeleafExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
			auth.userDetailsService(userDetailsService);

			//		auth.inMemoryAuthentication()
//			.withUser("customer").password("pass").roles("CUSTOMER").and()
//			.withUser("admin").password("pass").roles("ADMIN");
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/usertest").hasAnyRole("USER", "ADMIN")
			.antMatchers("/user/**").hasRole("ADMIN")
			.antMatchers("/product/**").hasAnyRole("ADMIN")
			.antMatchers("/").permitAll()
			.and().formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/")
			.permitAll()
//			.failureUrl("/loginFailed")
			.and().logout()
//			.invalidateHttpSession(false)
//			.logoutUrl("/logout")
			.logoutSuccessUrl("/home")
//			;

		    .and()
		    .exceptionHandling()
		    .accessDeniedPage("/notAuthorized")
		    ;
	}
//	
	 

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zema.isms.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



/**
 *
 * @author ewawuye
 */
@Configuration
@EnableWebSecurity
public class AmsSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailService")
	private UserDetailsService amsUserDetailsService;
    	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			BCryptPasswordEncoder encoder =	new BCryptPasswordEncoder( );
			auth.userDetailsService(amsUserDetailsService).passwordEncoder(encoder);
		auth.authenticationProvider(authenticationProvider());
                        }
        
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
		BCryptPasswordEncoder encoder =	new BCryptPasswordEncoder( );
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(amsUserDetailsService);
        authenticationProvider.setPasswordEncoder(encoder);
        return authenticationProvider;
    }
   @Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
			   // .antMatchers("/asset/**","/report/**").permitAll()
                             .antMatchers("/request/request_list").hasAnyAuthority("DIRECTER")

                             .antMatchers("/request/store-kepeer-request-list").hasAnyAuthority("KEPEER ")
         .antMatchers("/request/finished-request").hasAnyAuthority("KEPEER ")
                      
                             .antMatchers("/request/requestApproveManager").hasAnyAuthority("MANAGER")
                           .antMatchers("/employee/*").hasAnyAuthority("MANAGER","ADMIN","KEPEER")
                        .antMatchers("/asset/*").hasAnyAuthority("MANAGER","KEPEER","ADMIN")
                        .antMatchers("/organization/*").hasAnyAuthority("ADMIN")
                        .antMatchers("/dept/*").hasAnyAuthority("ADMIN")
                        .antMatchers("/report/*").hasAnyAuthority("MANAGER","ADMIN","DIRECTOR","KEPEER")
                        .antMatchers("/catagory/*").hasAnyAuthority("MANAGER","ADMIN","KEPEER")
                        .antMatchers("/security/*").hasAnyAuthority("ADMIN")
                                .anyRequest().authenticated()
                          
        
                     	.and()
				.formLogin()
					.loginPage("/loginPage").loginProcessingUrl("/login").permitAll()
					
                       
			.and()
				.logout().permitAll()
			.and()
			   .exceptionHandling().accessDeniedPage("/access-denied")
                   
                .and()
                     .csrf().disable();
                        
	}
  
        /**
	 * Configure Web permissions (images, css, js, etc.)
	 */
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring()
		.antMatchers("/resource/**", "/static/**", "/css/**", "/image/**", "/js/**");
		
	}
}

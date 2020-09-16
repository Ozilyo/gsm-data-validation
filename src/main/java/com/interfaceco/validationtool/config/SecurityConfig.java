package com.interfaceco.validationtool.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.interfaceco.validationtool.usermanagement.service.UserDetailsServiceAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private UserDetailsServiceAdapter userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username, password, true " + "from account where username=?")
//				.authoritiesByUsernameQuery("select account.username, role.role_name from account, role "
//						+ "join accounts_roles on (accounts_roles.role_id = role.id) "
//						+ "where account.username=? and accounts_roles.account_id=account.id");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

		.authorizeRequests()
			.antMatchers("/login*").anonymous()
			.antMatchers("/sites/**").hasAuthority("ROLE_ADMIN")
			.antMatchers("/css/**", "/js/**", "/img/**", "/font/**").permitAll()
			.anyRequest().authenticated()
			
		  .and()
		.formLogin()
			.loginPage("/login")
	        .defaultSuccessUrl("/welcome",true)
		  .and()
		.logout()
			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	}

}

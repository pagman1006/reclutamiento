/**
 * 
 */
package com.inad.reclutamiento.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inad.reclutamiento.app.api.service.UserService;
import com.inad.reclutamiento.app.auth.handler.LoginSuccesHandler;

/**
 * @author P. Andres Gasca (andresg1006@gmail.com)
 *
 */
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private LoginSuccesHandler successHandler;

	@Autowired
	private UserService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/css/**", "/js/**", "/img/**", "/locale","/solicitud/**").permitAll()
			.antMatchers("/candidato/**").hasAnyRole("USER").anyRequest().authenticated()
			.and().formLogin().successHandler(successHandler).loginPage("/login").permitAll()
			.defaultSuccessUrl("/").failureUrl("/login?error=true")
			.and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/error_403");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected UserDetailsService userDetailsService() {
		// Codigo para crear usuarios y contraseñas
		/*
		logger.info("Inicio de creacion de usuarios");
		
		// User Role
		UserDetails theUser = User.withUsername("andresg")
				.password(passwordEncoder.encode("12345")).roles("USER").build();
				
		logger.info("Usuario: " + theUser.getUsername());
		logger.info("Pass Usuario: (12345) " + theUser.getPassword());
		
		// Admin Role
		UserDetails theAdmin = User.withUsername("admin")
				.password(passwordEncoder.encode("admin")).roles("ADMIN").build();
		
		logger.info("Admin: " + theAdmin.getUsername());
		logger.info("Pass Admin: (admin) " + theAdmin.getPassword());
		*/
		return super.userDetailsService();
	}

}

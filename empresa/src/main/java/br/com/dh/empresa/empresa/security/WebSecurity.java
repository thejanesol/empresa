package br.com.dh.empresa.empresa.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
	
	//Injeção do datasource (referencia lá no application.properties)
	@Autowired
	DataSource dataSource;
	
	@Autowired
	private ImplementsUserDetailsService UserDetailsService;
	
	//Autenticação
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {	
		auth.userDetailsService(UserDetailsService)
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
    
	@Override 
	protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.POST, "/").permitAll()
        .antMatchers(HttpMethod.GET, "/autorizacao/**").hasRole("GERENTE")
        .antMatchers(HttpMethod.GET, "/funcionario/**").hasRole("GERENTE")
        .antMatchers(HttpMethod.POST, "/funcionario/**").hasRole("GERENTE")
        .antMatchers(HttpMethod.DELETE, "/funcionario/**").hasRole("GERENTE")
        .antMatchers(HttpMethod.PUT, "/funcionario/**").hasRole("GERENTE")
        .anyRequest().authenticated() //every request requires the user to be authenticated
        .and().formLogin().permitAll()
        .and().httpBasic() //HTTP Basic Authentication is supported - resolução erro no postman
        .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }
}


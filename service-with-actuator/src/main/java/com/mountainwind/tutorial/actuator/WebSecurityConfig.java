package com.mountainwind.tutorial.actuator;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http
	    	.authorizeRequests()
	    		.antMatchers("/").permitAll()
	    		.anyRequest()
	    		.fullyAuthenticated()
	    		.and()
	    	.httpBasic().and()
	    	.csrf().disable();
	  }
	
	
	
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/contacts").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .csrf().disable()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("password").roles("USER", "ADMIN");
//    }
}

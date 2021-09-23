package com.example.springboot.bookstore.bookstorewebapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource ;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        String bookApi = "/api/books/**" ;
        String customerApi = "/api/customers/**" ;
        String admin ="ADMIN" ;
        http.authorizeRequests().antMatchers(HttpMethod.GET,customerApi).permitAll()
                .antMatchers(HttpMethod.GET,bookApi).permitAll()
                .antMatchers(HttpMethod.GET,customerApi).permitAll()
                .antMatchers(HttpMethod.POST,bookApi).hasRole(admin)
                .antMatchers(HttpMethod.POST,customerApi).permitAll()
                .antMatchers(HttpMethod.PUT,customerApi).permitAll()
                .antMatchers(HttpMethod.PUT,bookApi).permitAll()
                .antMatchers(HttpMethod.DELETE,bookApi).hasRole(admin)
                .antMatchers(HttpMethod.DELETE,customerApi).hasRole(admin)
                .anyRequest()
                .hasAnyRole(admin,"CUSTOMER" )
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .and()
                .csrf()
                .disable();
    }
}

package com.example.springboot.bookstore.bookstorewebapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource ;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        /* User.UserBuilder userBuilder = User.withDefaultPasswordEncoder() ;
        auth.inMemoryAuthentication()
        .withUser(userBuilder.username("abhi").password("Abhi@276").roles("CUSTOMER"))
        .withUser(userBuilder.username("admin").password("Admin@276").roles("ADMIN")); */
        System.out.println(dataSource.getConnection());
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username=?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username=?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/api/customers/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/books/**").permitAll()
                .antMatchers(HttpMethod.GET,"/api/customers/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/customers/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/customers/**").permitAll()
                .antMatchers(HttpMethod.PUT,"/api/books/**").permitAll()
                .antMatchers(HttpMethod.DELETE,"/api/books/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/api/customers/**").hasRole("ADMIN")
                .anyRequest()
                .hasAnyRole("ADMIN","CUSTOMER" )
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

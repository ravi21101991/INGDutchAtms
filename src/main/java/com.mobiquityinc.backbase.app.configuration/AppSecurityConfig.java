package com.mobiquityinc.backbase.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static com.mobiquityinc.backbase.app.constants.PathConstants.ALL_ATMS;
import static com.mobiquityinc.backbase.app.constants.PathConstants.LOGOUT;
import static com.mobiquityinc.backbase.app.constants.PathConstants.ROOT;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .defaultSuccessUrl(ALL_ATMS, true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher(LOGOUT))
                .logoutSuccessUrl(ROOT)
                .invalidateHttpSession(true)
                .and()
                .httpBasic();
    }
}

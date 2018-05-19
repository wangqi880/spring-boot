package com.j.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/css/**", "/js/**", "/fonts/**", "/index").permitAll()  //都可以访问
                .antMatchers("/users/**").hasRole("USER")   // 需要相应的角色才能访问
                .antMatchers("/huiadmin/**").hasRole("ADMIN")   // 需要相应的角色才能访问
                .and().csrf().disable()
                .formLogin()   //基于 Form 表单登录验证
                .loginPage("/hLogin").failureUrl("/login-error").loginProcessingUrl("/login");  // 自定义登录界面

    }

    @Override
    protected UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(); // 在内存中存放用户信息
        manager.createUser(User.withUsername("wangqi").password("wangqi").roles("USER").build());
        manager.createUser(User.withUsername("admin").password("admin").roles("USER","ADMIN").build());
        return manager;
    }

    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }
}

package com.meteor.demo.spring.security.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created  bhy on 2020/3/16
 * 继承WebSecurityConfigurerAdapter  进行方法重载
 **/
@Configuration
@EnableWebSecurity //启用 security 安全性
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 选择http 安全进行改写
     * 这个简单的默认配置指定了该如何保护HTTP请求，以及客户端认证 用户的方案。
     * 通过调用authorizeRequests()和 anyRequest().authenticated()就会要求所有进入应用的 HTTP请求都要进行认证。
     * 它也配置Spring Security支持基于表单的登 录以及HTTP Basic方式的认证。
     *
     *  用来定义 哪些放过哪些不放过及role 认证
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**
         *  默认的super代码
         *  http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
         */
        http.
                formLogin().and().
                authorizeRequests().antMatchers("/**").hasAnyRole("user").anyRequest().authenticated();
//        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
//        super.configure(http);
    }


    /**
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.userDetailsService()
//        auth.userDetailsService()
        auth.inMemoryAuthentication().withUser("user").password("123456").roles("user").and()
                .withUser("admin").password("123456").roles("user","admin");
//        super.configure(auth);
    }


}

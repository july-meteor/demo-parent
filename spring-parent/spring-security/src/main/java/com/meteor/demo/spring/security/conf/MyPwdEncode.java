package com.meteor.demo.spring.security.conf;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created  bhy on 2020/3/16
 *  除了比较数据库和网页输入的值以外没啥意义
 **/
@Component
public class MyPwdEncode implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        System.err.println(rawPassword);
        return "1111";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        System.err.println(rawPassword);

        System.err.println(encodedPassword);
        return true;
    }
}

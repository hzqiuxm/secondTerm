package com.ziniuxiaozhu.jiemi.secondTerm;

import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.StandardEnvironment;

/**
 * Copyright © 2020年 secondTerm. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/11 12:33
 */

@SpringBootTest
public class ApplicationTest {


    @Test
    void testJasypt(){

        System.setProperty("jasypt.encryptor.password", "pigx");

        StringEncryptor stringEncryptor = new DefaultLazyEncryptor(new StandardEnvironment());
        System.out.println(stringEncryptor.decrypt("ltJPpR50wT0oIY9kfOe1Iw=="));
        System.out.println("-------");
        System.out.println(stringEncryptor.encrypt("geek"));


    }
}

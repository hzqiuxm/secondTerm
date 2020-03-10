package com.ziniuxiaozhu.jiemi.secondTerm.gateways.http;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Copyright © 2020年 secondTerm. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * HTTP请求，调用健康证
 * @date 2020/3/9 18:05
 */

@RestController
public class HttpClient {





    public static void main(String[] args) {


        String result1 = HttpUtil.get("https://www.baidu.com");


        System.out.println(result1);
    }


    @GetMapping("/jkz")
    public String getJHZ(@RequestParam(defaultValue = "330106198604141119") String sfzh) {

        HashMap<String, Object> paramMap = new HashMap<>();

        System.out.println("传入的身份证：" + sfzh);

        long timeMillis = System.currentTimeMillis();

        System.out.println("timeMillis = " + timeMillis);
        String sign = DigestUtil.md5Hex("4ea4bc6e0bb241ebba216b9450144eb9" + "de2c5839afd24aa685839b7096b966fa" + timeMillis);


        paramMap.put("appKey","4ea4bc6e0bb241ebba216b9450144eb9");
        paramMap.put("sfzh",sfzh);
        paramMap.put("requestTime",timeMillis);
        paramMap.put("sign", sign);


        System.out.println("send prepare is ok!" + sign);

//        String result= HttpUtil.get("http://10.49.132.13/gateway/api/001008010010001/dataSharing/n093113av7zg4M8a.htm", paramMap);


        String result= HttpUtil.get("http://10.49.132.13/gateway/api/001008010010001/dataSharing/n093113av7zg4M8a.htm?appKey=4ea4bc6e0bb241ebba216b9450144eb9&sfzh=" + sfzh +"&requestTime=" + timeMillis +"&sign=" + sign.toString());

        System.out.println("request is send .........." + result);
        return result;

    }


}

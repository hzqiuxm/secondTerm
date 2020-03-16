package com.ziniuxiaozhu.jiemi.secondTerm.gateways.http;

import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

//
//        String result1 = HttpUtil.get("https://www.baidu.com");
//
//        System.out.println(result1);


        String json1 = "{\"code\":\"00\",\"msg\":\"成功\",\"data\":\"\",\"datas\":{\"refreshSecret\":\"664383d2453f450eb2995910c123d3ca\",\"refreshSecretEndTime\":1584512115567,\"requestSecret\":\"ee037137840c4953b0138526a1493cc7\",\"requestSecretEndTime\":1584340215567},\"dataCount\":0,\"requestId\":null,\"interfaces\":null,\"secondaryResults\":null}";

        JSONObject jsonObject = JSONUtil.parseObj(json1);


        String code = jsonObject.getStrEscaped("code");
        String datas = jsonObject.getStrEscaped("datas");

        System.out.println("code = " + code);

        JSONObject jsonDatas = JSONUtil.parseObj(datas);

        String requestSecret = jsonDatas.getStrEscaped("requestSecret");
        String refreshSecret = jsonDatas.getStrEscaped("refreshSecret");

        System.out.println("requestSecret = " + requestSecret + "\n" + "refreshSecret = " + refreshSecret);
    }


    @GetMapping("/jkz")
    public String getJHZ(@RequestParam(defaultValue = "330106198604141119") String sfzh) {

        System.out.println("==================================开始获取临时密钥==================================================");


        long currentTimeMillis = System.currentTimeMillis();


        String sign1 = DigestUtil.md5Hex("4ea4bc6e0bb241ebba216b9450144eb9" + "de2c5839afd24aa685839b7096b966fa" + currentTimeMillis);

        System.out.println("sign1 = " + sign1);

        String getTmpToken = "http://10.49.132.13/gateway/app/refreshTokenByKey.htm?appKey=4ea4bc6e0bb241ebba216b9450144eb9&sfzh="+"&requestTime=" + currentTimeMillis +"&sign=" + sign1.toString();;

        System.out.println("getTmpToken = " + getTmpToken);

        String result= HttpUtil.get(getTmpToken);

        JSONObject jsonObject = JSONUtil.parseObj(result);


        String code = jsonObject.getStrEscaped("code");
        String datas = jsonObject.getStrEscaped("datas");

        System.out.println("code = " + code);

        JSONObject jsonDatas = JSONUtil.parseObj(datas);

        String requestSecret = jsonDatas.getStrEscaped("requestSecret");
        String refreshSecret = jsonDatas.getStrEscaped("refreshSecret");


        if("00".endsWith(code)){

           return getJKZ(sfzh,requestSecret,currentTimeMillis);

        }else {

            return "接口调用失败！";
        }


    }

    private String getJKZ(@RequestParam(defaultValue = "330106198604141119") String sfzh,String tokenValue,Long reqTime) {
        System.out.println("==================================开始调用健康证查询接口==================================================");

        System.out.println("传入的身份证：" + sfzh);

        long timeMillis = System.currentTimeMillis();

        System.out.println("timeMillis = " + timeMillis);
        String sign = DigestUtil.md5Hex("4ea4bc6e0bb241ebba216b9450144eb9" + tokenValue + timeMillis);


        System.out.println("send prepare is ok!" + sign);

//        String result= HttpUtil.get("http://10.49.132.13/gateway/api/001008010010001/dataSharing/n093113av7zg4M8a.htm", paramMap);

        String reqUrl = "http://10.49.132.13/gateway/api/001008010010001/dataSharing/n093113av7zg4M8a.htm?appKey=4ea4bc6e0bb241ebba216b9450144eb9&sfzh=" + sfzh +"&requestTime=" + timeMillis +"&sign=" + sign.toString();

        System.out.println("reqUrl= " + reqUrl);

        String result= HttpUtil.get(reqUrl);

        System.out.println("request is send .........." + result);
        return result;
    }


}

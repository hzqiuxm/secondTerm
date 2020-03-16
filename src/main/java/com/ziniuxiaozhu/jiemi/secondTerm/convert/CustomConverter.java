package com.ziniuxiaozhu.jiemi.secondTerm.convert;

import cn.hutool.core.convert.Converter;

/**
 * Copyright © 2020年 secondTerm. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * 自定义转换器
 * @date 2020/3/10 11:41
 */
public class CustomConverter implements Converter<MyINfo> {

    @Override
    public MyINfo convert(Object value, MyINfo defaultValue) throws IllegalArgumentException {


        System.out.println(value);

        defaultValue.setName("ZNXZ-"+ ((TempVo)value).getVoName());
        defaultValue.setAge(((TempVo)value).getVoAge()+1);

        System.out.println(defaultValue);

        return defaultValue;
    }
}

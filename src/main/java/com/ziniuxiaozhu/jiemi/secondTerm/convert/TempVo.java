package com.ziniuxiaozhu.jiemi.secondTerm.convert;

/**
 * Copyright © 2020年 secondTerm. All rights reserved.
 *
 * @author 临江仙 hzqiuxm@163.com
 * @date 2020/3/10 11:47
 */
public class TempVo {

    private String voName;
    private int voAge;

    public TempVo(String voName, int voAge) {
        this.voName = voName;
        this.voAge = voAge;
    }

    public String getVoName() {
        return voName;
    }

    public void setVoName(String voName) {
        this.voName = voName;
    }

    public int getVoAge() {
        return voAge;
    }

    public void setVoAge(int voAge) {
        this.voAge = voAge;
    }
}

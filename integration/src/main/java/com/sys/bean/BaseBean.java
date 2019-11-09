package com.sys.bean;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class BaseBean {
    public static final String DELETE = "1";
    public static final String NORMAL = "0";
    protected String id;
    protected Date updateTime;
    protected  String delFlag;
    public void preInsert(){
        this.id = UUID.randomUUID().toString().replace("-","");
        this.updateTime = new Date();
        this.delFlag = NORMAL;
    }
public void preUpdate(){
        this.updateTime = new Date();
}

}

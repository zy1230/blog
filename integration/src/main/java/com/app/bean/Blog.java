package com.app.bean;

import com.sys.bean.BaseBean;
import com.sys.bean.User;
import lombok.Data;


import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class Blog extends BaseBean {

    private String title;
    private String author;
    private String content;

    private User user;

    private Date publishDate;

  //  SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd");



}

package com.sys.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseBean{
    private String username;
    private  String password;
    private String phone;
    private Date birthday;




}

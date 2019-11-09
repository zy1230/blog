package com.app.service;

import com.app.dao.UserDao;
import com.sys.service.BaseSevice;
import com.sys.bean.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseSevice<UserDao,User> {
}

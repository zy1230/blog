package com.app.service;

import com.app.bean.Blog;
import com.app.dao.BlogDao;
import com.sys.service.BaseSevice;
import org.springframework.stereotype.Service;

@Service
public class BlogService extends BaseSevice<BlogDao,Blog> {
}

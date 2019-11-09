package com.app.web;

import com.app.bean.Blog;
import com.app.service.BlogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("blog")
public class BlogController {

    @Autowired
    private BlogService blogService;


    @RequestMapping("index")
    public String index(){
        return "blogList";
    }

    //-------------------------------------

    @RequestMapping("index1")
    public String index1(){
        return "blogList2";
    }

    @RequestMapping("all")
    @ResponseBody
    public List<Blog> findAll(){
        return blogService.findAll();
    }


    //-------------------------------------------


    @RequestMapping("page")
    @ResponseBody
    public PageInfo<Blog> page(Integer pageNum,Integer pageSize,Blog blog){
        return blogService.page(pageNum,pageSize,blog);
    }
    @RequestMapping("add")
    public String add(){
        return "blog";
    }
    @RequestMapping("insert")
    @ResponseBody
    public Blog insert(Blog blog){
        System.out.println(blog);
        blogService.insert(blog);
        return blog;
    }
    @RequestMapping("zhan")
    public String zhan(){
        return "zhanshi";
    }

    @RequestMapping("title")
    @ResponseBody
    public Blog title(String title){
         return blogService.findByTitle(title);
    }
}

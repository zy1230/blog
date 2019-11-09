package com.app.web;

import com.app.service.UserService;
import com.sys.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController{
    @Autowired
    private UserService userService;
    @GetMapping("/find/{id}")
    @ResponseBody
    public User find(@PathVariable("id")String id){
        return userService.findById(id);
    }

}

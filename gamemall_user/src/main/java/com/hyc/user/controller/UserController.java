package com.hyc.user.controller;

import com.hyc.user.dao.User;
import com.hyc.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@RestController
//@CrossOrigin
//@RequestMapping("/user")
@Controller
public class UserController {
    /*登录：
    *
    * */
    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public String login(){
        return "login";
    }



}

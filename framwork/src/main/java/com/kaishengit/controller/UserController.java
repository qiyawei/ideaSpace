package com.kaishengit.controller;

import com.kaishengit.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        System.out.println("hello springmvc");
        model.addAttribute("name","lisi");
        return "users";
    }
    //"/users/new"
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String saveUser(){
        return "new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveUser(String name,String pwd){
        //Admin admin
       // System.out.println(admin.getName() +"  "+ admin.getPwd());
        //String name,String pwd
        System.out.println("Name " + name+" Pwd " + pwd);
        return "redirect:/users";
    }
}

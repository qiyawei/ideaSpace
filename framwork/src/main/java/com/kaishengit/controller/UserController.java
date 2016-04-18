package com.kaishengit.controller;

import com.kaishengit.entity.Admin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {
  /*  @RequestMapping(method = RequestMethod.GET)
    public String list(Model model){
        System.out.println("hello springmvc");
        model.addAttribute("name","lisi");
        return "users";
    }*/
  @RequestMapping(method = RequestMethod.GET)
  public ModelAndView list(ModelAndView model){
      System.out.println("users");
      model.addObject("name","张三");
      return model;
  }
    //"/users/new"
    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String saveUser(){
        return "new";
    }
    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public String saveUser(String name1,String pwd1){
        //Admin admin
       // System.out.println(admin.getName() +"  "+ admin.getPwd());
        //String name,String pwd
        System.out.println("Name " + name1+" Pwd " + pwd1);
        return "redirect:/users";
    }
    @RequestMapping(value = "/{id:\\d+}",method = RequestMethod.GET)
    public String show(@PathVariable int id){
        //不进行正则验证会400错误 验证没通过会404
        System.out.println(id);
        return "redirect:/users";
    }
    @RequestMapping(value = "/{typeid:\\d+}/{id:\\d+}")
    public String show(@PathVariable int typeid,@PathVariable int id){
        System.out.println("typeid " + typeid + "  id  "+ id);
        return "redirect:/users";
    }
    @RequestMapping(value = "/page{pageNo:\\d+}")
    public String show2(@PathVariable int pageNo){
        System.out.println(pageNo);
        return "redirect:/users";
    }
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String find(String name,int id){
        System.out.println(name +"   "+ id);
        return "redirect:/users";
    }
    @RequestMapping(value = "/validate",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Admin validate(){
        Admin admin = new Admin();
        admin.setName("aaa");
        admin.setPwd("4444");
        admin.setId(4);
        return admin;
    }

    @RequestMapping("/http")
    public String getHttp(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        return "redirect:/users";
    }


















}

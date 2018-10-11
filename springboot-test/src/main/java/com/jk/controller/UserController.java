package com.jk.controller;

import com.jk.model.ResultPage;
import com.jk.model.UserBean;
import com.jk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toLayout")
    public String toLayout(){
        return "main";
    }

    @RequestMapping("toUserPage")
    public String toUserPage(){
        return "userList";
    }

    @RequestMapping("queryUserList")
    @ResponseBody
    public ResultPage queryUserList(UserBean userBean){
        ResultPage resultPage = userService.queryUserList(userBean);
        return resultPage;
    }

    @RequestMapping("toAddUser")
    public String toAddUser(){
        return "addUser";
    }

    @RequestMapping("addUser")
    @ResponseBody
    public String addUser(UserBean userBean){
        userService.addUser(userBean);
        return "{}";
    }

    @RequestMapping("toEditUser")
    public String toEditUser(Model model, Integer userId){
        UserBean editUser = userService.queryUserById(userId);
        model.addAttribute("editUser", editUser);
        return "editUser";
    }

    @RequestMapping("editUser")
    @ResponseBody
    public String editUser(UserBean userBean){
        userService.editUser(userBean);
        return "{}";
    }

}

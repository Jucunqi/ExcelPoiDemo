package com.jcq.exceldemo.controller;

import com.jcq.exceldemo.pojo.User;
import com.jcq.exceldemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getAllUser")
    public String getAllUser(Model model) {
        List<User> users = userService.getAllUser();
        model.addAttribute("users", users);
        return "show";
    }

    @RequestMapping("insUser")
    public String insUser(User user) {
        userService.insUser(user);
        return "redirect:getAllUser";
    }
    @RequestMapping("show")
    public String toShow() {
        return "show";
    }

    @RequestMapping("tolist")
    public String toList() {
        return "list";
    }
}

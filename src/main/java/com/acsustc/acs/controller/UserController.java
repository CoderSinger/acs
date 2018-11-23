package com.acsustc.acs.controller;

import com.acsustc.acs.entity.User;
import com.acsustc.acs.repository.UserRepository;
import com.acsustc.acs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/*")
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    private User user = new User();

    @RequestMapping("/say")
    public String say()
    {
        return "hello";
    }


    @RequestMapping("/index")
    public String index(HttpSession httpSession) {
        httpSession.getAttribute("userLogin");
        return "index";
    }


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/login")
    public String login() {
        String str = "";
        String username = user.getUserName();
        if(username !=  null) {
            str = "index";
        }else {
            str = "login";
        }
        return str;
    }


    @RequestMapping("/ulogin")
    public String login(HttpServletRequest request, HttpSession session) {
        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        user = userService.login(username, password);

        String str = "";
        if(user != null) {
            session.setAttribute("userLogin", user);
            str = "index";
        }else {
            str = "login";
        }
        return str;
    }


    @RequestMapping("/uregister")
    public String register(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        String phoneNumber = request.getParameter("phoneNumber");
        String str = "";
        if(password.equals(password2)) {
            user = userService.select(userName);
            if(user  ==  null) {
                User user = new User(userName, password, phoneNumber);
                userService.insert(user);
                str = "login";
            }else {
                str = "register";
            }
        }else {
            str = "register";
        }
        return str;
    }


}

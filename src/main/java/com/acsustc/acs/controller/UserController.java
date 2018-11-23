package com.acsustc.acs.controller;

import com.acsustc.acs.entity.User;
import com.acsustc.acs.repository.UserRepository;
import com.acsustc.acs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserService userService;

    private User user = new User();

    /**
     * 域名访问重定向
     * 作用：输入域名后重定向到index（首页）
     * */
    @RequestMapping("")
    public String index(HttpServletResponse response) {
        //重定向到 /index
        return response.encodeRedirectURL("/index");
    }

    /**
     * 首页API
     * 作用：显示首页
     * */
    @RequestMapping("/index")
    public String home(Model model) {
        //对应到templates文件夹下面的index
        return "index";
    }

    //解决“Request method 'GET' not supported”问题
    @RequestMapping(value = "/register" , method = RequestMethod.GET)
    public String toRegister(){
        return  "register";
    }
    //解决“Request method 'GET' not supported”问题
    @RequestMapping(value = "/login" , method = RequestMethod.GET)
    public String toLogin(){
        return  "login";
    }
    /**
     * 注册API
     * @method：post
     * @param user（从View层传回来的user对象）
     * @return 重定向
     * */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPost(Model model,
                               //这里和模板中的th:object="${user}"对应起来
                               @ModelAttribute(value = "user") User user,
                               HttpServletResponse response) {
        //我们可以用Sout这种最原始打印方式来检查数据的传输
        System.out.println("Controller信息:"+user.getUserName());
        System.out.println("Controller密码:"+user.getPassword());
        //使用userService处理业务
        String result = userService.register(user);
        //将结果放入model中，在模板中可以取到model中的值
        //这里就是交互的一个重要地方，我们可以在模板中通过这些属性值访问到数据
        model.addAttribute("result", result);
        //开始重定向，携带数据过去了。
        return response.encodeRedirectURL("/index");
    }

    /**
     * 登录API
     * @method：post
     * @param user（从View层传回来的user对象）
     * @return 重定向
     * */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPost(Model model,
                            @ModelAttribute(value = "user1") User user,
                            HttpServletResponse response,
                            HttpSession session) {
        System.out.println(user.getUserName() + "!!!!");
        String result = userService.login(user);
        if (result.equals("登录成功")) {
            //session是作为用户登录信息保存的存在
            session.setAttribute("user",user);
        }
        model.addAttribute("result", result);
        return response.encodeRedirectURL("/index");
    }
    /**
     * 注销API
     * @method：get
     * @return 首页
     * */
    @RequestMapping(value = "/loginOut", method = RequestMethod.GET)
    public String loginOut(HttpSession session) {
        //从session中删除user属性，用户退出登录
        session.removeAttribute("user");
        return "index";
    }
}


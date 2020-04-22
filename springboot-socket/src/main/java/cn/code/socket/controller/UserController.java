package cn.code.socket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * html访问
 *
 * @author zlh-dev
 * @date 2020/04/19 21:15
 */
@Controller
public class UserController {

    @RequestMapping("login.html")
    public String loginHtml() {
        return "login";
    }

    @RequestMapping("login")
    public String login(String username) {

        return "socket";
    }
}

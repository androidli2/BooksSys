package com.jiahao.book.controller;

import com.jiahao.book.pojo.User;
import com.jiahao.book.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2016/8/15.
 */
@Controller
public class BaseController {

    @Resource
    private UserService userService;

    @RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("userCode") String userCode, @RequestParam("password") String password, HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException {
        User user = userService.userLogin(userCode, password);
        //System.out.println(user.toString());
        if(null == user) {
            PrintWriter out = response.getWriter();
            out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=utf-8'>");
            out.print("<script>");
            out.print("alert('登录失败，登录账号或密码错误，请重新输入');");
            out.print("window.location.href='login'");
            out.print("</script>");
            out.close();
        } else {
            session.setAttribute("user", user);
            return "redirect:book/list";
        }
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:login";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String toRegister() {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        String userCode = request.getParameter("userCode");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");

        User user = new User();
        user.setUserCode(userCode);
        user.setPassword(password);
        user.setGender(gender);
        user.setEmail(email);

        int r = userService.addUser(user);
        if(r == 1) {
            model.addAttribute("u", user);
            return "success";
        }
        else {
            PrintWriter out = response.getWriter();
            out.print("<meta   http-equiv='Content-Type'   content='text/html;   charset=utf-8'>");
            out.print("<script>");
            out.print("alert('注册失败！');");
            out.print("window.location.href='register'");
            out.print("</script>");
            out.close();
            return "register";
        }
    }
}

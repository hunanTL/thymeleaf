package com.example.tl.controller;

import com.example.tl.pojo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author <a href="mailto:lei.tan@vtradex.net">谭磊/a>
 * @since 2019-05-14 20:55
 */
@Controller
public class DemoController {

    @RequestMapping("/index")
    public String show(Model model){
       model.addAttribute("msg", "hello");
        model.addAttribute("username", "tanlei");
        model.addAttribute("key", new Date());
       return "index";
    }

    @RequestMapping("/list")
    public String show2(Model model){
        model.addAttribute("sex", "男");
        model.addAttribute("id", "2");
        return "list";
    }

    @RequestMapping("/show3")
    public String show3(Model model){
        Map<String,Users> map=new HashMap<>();
        map.put("U1",new Users(1,"tanlei","12"));
        map.put("U2",new Users(2,"tDei","13"));
        map.put("U3",new Users(3,"taASDnlei","14"));
        model.addAttribute("map",map);
        return "show";
    }

    @RequestMapping("/show4")
    public String show4(HttpServletRequest request, Model model){
        request.setAttribute("req", "HttpServletRequest");
        request.getSession().setAttribute("sess", "HttpSession");
        request.getSession().getServletContext().setAttribute("app", "Application");
        return "show2";
    }

    @RequestMapping("/{path}")
    public  String  showInfo(@PathVariable String page ){
        return page;
    }
}

package com.bosch.pj_ms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class AdminController {

    @PostMapping("/session")
    @ResponseBody
    public HashMap<String, Integer> login(String username, String password, HttpServletRequest request) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        if ("admin".equals(username) && "123456".equals(password)) {
            hashMap.put("result", 1);
            request.getSession().setAttribute("username", "admin");
        }
        else
            hashMap.put("result", 0);
        return hashMap;
    }

    @GetMapping("/index.html")
    public String index(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("username"));
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }
}

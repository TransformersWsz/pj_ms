package com.bosch.pj_ms.controller;

import com.bosch.pj_ms.pojo.User;
import com.bosch.pj_ms.service.LogService;
import com.bosch.pj_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @Autowired
    HttpSession session;

    @PostMapping("/session")
    @ResponseBody
    public HashMap<String, Integer> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<User> list = userService.findUserByNameAndPasswd(username, password);
        if (list.size() == 1) {
            Integer userId = list.get(0).getId();
            hashMap.put("userId", userId);
            session.setAttribute("userId", userId);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String operation = username + " login successfully at " + df.format(new Date());
            logService.addLogService(operation);
        }
        else {
            hashMap.put("userId", -1);
        }
        return hashMap;
    }

    @DeleteMapping("/session/{id}")
    @ResponseBody
    public HashMap<String, Integer> logout(@PathVariable("id") Integer userId) {
        session.removeAttribute("userId");
        System.out.println(userId);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("result", 1);
        return hashMap;
    }

    @GetMapping("/test")
    public void test(HttpServletRequest request) {
        System.out.println("test....");
    }


    @GetMapping("/index.html")
    public String index(HttpServletRequest request) {
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }
}

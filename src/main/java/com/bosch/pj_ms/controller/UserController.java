package com.bosch.pj_ms.controller;

import com.bosch.pj_ms.pojo.User;
import com.bosch.pj_ms.service.LogService;
import com.bosch.pj_ms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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

    @PostMapping("/session")
    @ResponseBody
    public HashMap<String, Integer> login(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + " , " + password);
        HashMap<String, Integer> hashMap = new HashMap<>();
        List<User> list = userService.findUserByNameAndPasswd(username, password);
        if (list.size() == 1) {
            hashMap.put("result", 1);
            request.getSession().setAttribute("username", username);

            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String operation = username + " login successfully at " + df.format(new Date());
            logService.addLogService(operation);
        }
        else {
            hashMap.put("result", 0);
        }
        return hashMap;
    }

    @DeleteMapping("/session")
    public void logout(HttpServletRequest request) {
        request.getSession().setAttribute("username", null);
    }


    @GetMapping("/index.html")
    public String index(HttpServletRequest request) {
        System.out.println(request.getSession().getAttribute("admin_session"));
        return "index";
    }

    @GetMapping("/login.html")
    public String login() {
        return "login";
    }
}

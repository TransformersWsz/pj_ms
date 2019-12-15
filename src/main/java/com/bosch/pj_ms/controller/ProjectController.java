package com.bosch.pj_ms.controller;

import com.bosch.pj_ms.pojo.Project;
import com.bosch.pj_ms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // [分页] 查询项目
    @GetMapping("/pj")
    @ResponseBody
    public HashMap<String, Object> getProjects(Integer limit, Integer offset) {
        List<Project> pjs = projectService.findPartProjects(limit, offset);
        int total = projectService.findAllProjects().size();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total", total);
        hashMap.put("rows", pjs);
        return hashMap;
    }

    // 新建项目
    @PostMapping("/pj")
    @ResponseBody
    public HashMap<String, Integer> addProject(String mcr_id, String pj_name, String pj_date, String pj_des) throws IOException {
        Integer pj_id = projectService.addProjectService(mcr_id, pj_name, pj_des, pj_date);
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("pj_id", pj_id);
        return hashMap;
    }
}

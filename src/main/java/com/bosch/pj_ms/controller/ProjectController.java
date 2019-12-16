package com.bosch.pj_ms.controller;

import com.bosch.pj_ms.pojo.Project;
import com.bosch.pj_ms.service.LogService;
import com.bosch.pj_ms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private LogService logService;

    public String getDatetime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    public String getPj(Integer pj_id, String mcr_id, String pj_name, String pj_des, String pj_date) {
        return "{" + pj_id + " , " + mcr_id + " , " + pj_name + " , " + pj_des + " , " + pj_date + "}";
    }

    // [分页] 查询项目
    @GetMapping("/pj")
    @ResponseBody
    public HashMap<String, Object> getProjects(Integer limit, Integer offset, String year_name) {
        List<Project> pjs = projectService.findPartProjects(limit, offset, year_name);
        int total = projectService.findAllProjects(year_name).size();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("total", total);
        hashMap.put("rows", pjs);
        return hashMap;
    }

    @GetMapping("/test")
    @ResponseBody
    public HashMap<String, Object> test(Integer limit, Integer offset, String year_name) {
        System.out.println(limit + "," + offset + "," + year_name);
        List<Project> pjs = projectService.findPartProjects(limit, offset, year_name);
        int total = projectService.findAllProjects(year_name).size();
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

        String pj = getPj(pj_id, mcr_id, pj_name, pj_des, pj_date);
        String operation = "admin create " + pj + " || datetime: " + getDatetime();
        logService.addLogService(operation);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("pj_id", pj_id);
        return hashMap;
    }

    // 更新项目
    @PutMapping("/pj/{pj_id}")
    @ResponseBody
    public HashMap<String, Integer> editProject(@PathVariable("pj_id") Integer pj_id, String mcr_id, String pj_name, String pj_des, String pj_date) throws IOException {
        Project originProject = projectService.findSpecialProject(pj_id).get(0);
        String originPj = originProject.toString();

        Integer rows = projectService.modifyProject(pj_id, mcr_id, pj_name, pj_des, pj_date);

        String currentPj = getPj(pj_id, mcr_id, pj_name, pj_des, pj_date);
        String operation = "admin update " + originPj + " to " + currentPj + " || datetime: " + getDatetime();
        logService.addLogService(operation);


        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("rows", rows);
        return hashMap;
    }

    // 删除项目
    @DeleteMapping("/pj/{pj_id}")
    @ResponseBody
    public HashMap<String, Integer> delProject(@PathVariable("pj_id") Integer pj_id) throws IOException {
        Project originProject = projectService.findSpecialProject(pj_id).get(0);
        String originPj = originProject.toString();

        Integer rows = projectService.removeProject(pj_id);

        String operation = "admin delete " + originPj + " || datetime: " + getDatetime();
        logService.addLogService(operation);

        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("rows", rows);
        return hashMap;
    }
}

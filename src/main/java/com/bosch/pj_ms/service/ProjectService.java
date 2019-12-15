package com.bosch.pj_ms.service;

import com.bosch.pj_ms.pojo.Project;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    List<Project> findPartProjects(Integer limit, Integer offset);

    List<Project> findAllProjects();

    Integer addProjectService(String mcr_id, String pj_name, String pj_des, String pj_date) throws IOException;
}

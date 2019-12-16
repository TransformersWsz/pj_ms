package com.bosch.pj_ms.service;

import com.bosch.pj_ms.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.List;

public interface ProjectService {

    List<Project> findSpecialProject(Integer pj_id);

    List<Project> findPartProjects(Integer limit, Integer offset, String year_name);

    List<Project> findAllProjects(String year_name);

    Integer addProjectService(String mcr_id, String pj_name, String pj_des, String pj_date) throws IOException;

    Integer modifyProject(Integer pj_id, String mcr_id, String pj_name, String pj_des, String pj_date) throws IOException;

    Integer removeProject(Integer pj_id) throws IOException;
}

package com.bosch.pj_ms.service;

import com.bosch.pj_ms.pojo.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectService {

    List<Project> getPartProject(Integer limit, Integer offset);

    Integer addProjectService(String mcr_id, String pj_name, String pj_des, String pj_date);
}

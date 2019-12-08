package com.bosch.pj_ms.service.impl;

import com.bosch.pj_ms.mapper.ProjectMapper;
import com.bosch.pj_ms.pojo.Project;
import com.bosch.pj_ms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getPartProject(Integer limit, Integer offset) {
        return projectMapper.selectPartProject(limit, offset);
    }

    @Override
    public Integer addProjectService(String mcr_id, String pj_name, String pj_des, String pj_date) {
        return projectMapper.insertProject(mcr_id, pj_name, pj_des, pj_date);
    }
}

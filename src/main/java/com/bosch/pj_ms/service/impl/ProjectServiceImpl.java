package com.bosch.pj_ms.service.impl;

import com.bosch.pj_ms.mapper.ProjectMapper;
import com.bosch.pj_ms.pojo.Project;
import com.bosch.pj_ms.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findSpecialProject(Integer pj_id) {
        return projectMapper.selectSpecialProject(pj_id);
    }

    @Override
    public List<Project> findPartProjects(Integer limit, Integer offset, String year_name) {
        return projectMapper.selectPartProjects(limit, offset, year_name);
    }

    @Override
    public List<Project> findAllProjects(String year_name) {
        return projectMapper.selectAllProjects(year_name);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public Integer addProjectService(String mcr_id, String pj_name, String pj_des, String pj_date) throws IOException {
        Integer pj_id = -1;
        try {
            pj_id = projectMapper.insertProject(mcr_id, pj_name, pj_des, pj_date);
        }
        catch (Exception e) {
            throw new IOException();
        }
        finally {
            return pj_id;
        }
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public Integer modifyProject(Integer pj_id, String mcr_id, String pj_name, String pj_des, String pj_date) throws IOException {
        Integer rows = -1;
        try {
            rows = projectMapper.updateProject(pj_id, mcr_id, pj_name, pj_des, pj_date);
        }
        catch (Exception e) {
            throw new IOException();
        }
        finally {
            return rows;
        }
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public Integer removeProject(Integer pj_id) throws IOException {
        Integer rows = -1;
        try {
            rows = projectMapper.deleteProject(pj_id);
        }
        catch (Exception e) {
            throw new IOException();
        }
        finally {
            return rows;
        }
    }


}

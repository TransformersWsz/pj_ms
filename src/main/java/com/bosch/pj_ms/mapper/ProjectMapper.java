package com.bosch.pj_ms.mapper;

import com.bosch.pj_ms.pojo.Project;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select * from project limit #{offset}, #{limit}")
    List<Project> selectPartProject(@Param("limit") Integer limit, @Param("offset") Integer offset);

    @Insert("insert into project(mcr_id, pj_name, pj_des, pj_date) values(#{mcr_id}, #{pj_name}, #{pj_des}, #{pj_date})")
    Integer insertProject(@Param("mcr_id") String mcr_id, @Param("pj_name") String pj_name, @Param("pj_des") String pj_des, @Param("pj_date") String pj_date);
}

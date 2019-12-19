package com.bosch.pj_ms.mapper;

import com.bosch.pj_ms.pojo.Project;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProjectMapper {

    @Select("select * from project where pj_id=#{pj_id} order by pj_date desc")
    List<Project> selectSpecialProject(@Param("pj_id") Integer pj_id);

    @Select("select * from project where pj_date like concat(#{year_name}, '%') order by pj_date desc limit #{offset}, #{limit}")
    List<Project> selectPartProjects(@Param("limit") Integer limit, @Param("offset") Integer offset, @Param("year_name") String year_name);

    @Select("select * from project where pj_date like concat(#{year_name}, '%') order by pj_date desc")
    List<Project> selectAllProjects(@Param("year_name") String year_name);

    @Insert("insert into project(mcr_id, pj_name, pj_des, pj_date) values(#{mcr_id}, #{pj_name}, #{pj_des}, #{pj_date})")
    Integer insertProject(@Param("mcr_id") String mcr_id, @Param("pj_name") String pj_name, @Param("pj_des") String pj_des, @Param("pj_date") String pj_date);

    @Update("update project set mcr_id=#{mcr_id}, pj_name=#{pj_name}, pj_des=#{pj_des}, pj_date=#{pj_date} where pj_id=#{pj_id}")
    Integer updateProject(@Param("pj_id") Integer pj_id, @Param("mcr_id") String mcr_id, @Param("pj_name") String pj_name, @Param("pj_des") String pj_des, @Param("pj_date") String pj_date);

    @Delete("delete from project where pj_id=#{pj_id}")
    Integer deleteProject(@Param("pj_id") Integer pj_id);
}

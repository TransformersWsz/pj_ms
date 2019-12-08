package com.bosch.pj_ms.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LogMapper {

    @Insert("insert into log(operation) values(#{operation})")
    Integer insertLog(@Param("operation") String operation);
}

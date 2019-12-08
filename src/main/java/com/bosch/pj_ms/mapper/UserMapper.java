package com.bosch.pj_ms.mapper;

import com.bosch.pj_ms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from user where username=#{username} and password=#{password}")
    List<User> selectUserByNameAndPasswd(@Param("username") String username, @Param("password") String password);
}

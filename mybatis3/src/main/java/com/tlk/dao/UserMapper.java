package com.tlk.dao;

import com.tlk.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    List<User> getUserLimitList(Map<String , Integer> map);

    @Select("select * from mybatis.user")
    List<User> getUserAnnotation();

    //存在多个参数，参数前面必须加上@Param
    @Select("select * from mybatis.user where id = #{id}")
    User getuserbyid(@Param("id") int id);
}

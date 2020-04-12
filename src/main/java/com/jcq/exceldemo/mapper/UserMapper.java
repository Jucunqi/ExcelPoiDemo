package com.jcq.exceldemo.mapper;

import com.jcq.exceldemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    @Select("select * from user")
    List<User> selAllUser();
    @Insert("insert into user values(default,#{name},#{sex},#{address})")
    int insUser(User user);
}

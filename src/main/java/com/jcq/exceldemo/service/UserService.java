package com.jcq.exceldemo.service;

import com.jcq.exceldemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    int insUser(User user);
}

package com.jcq.exceldemo.service.impl;

import com.jcq.exceldemo.mapper.UserMapper;
import com.jcq.exceldemo.pojo.User;
import com.jcq.exceldemo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getAllUser() {
        return userMapper.selAllUser();
    }

    @Override
    public int insUser(User user) {
        return userMapper.insUser(user);
    }
}

package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.User;
import com.cool.prc.system.mapper.UserMapper;
import com.cool.prc.system.service.UserService;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}

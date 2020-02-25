package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.Role;
import com.cool.prc.system.mapper.RoleMapper;
import com.cool.prc.system.service.RoleService;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}

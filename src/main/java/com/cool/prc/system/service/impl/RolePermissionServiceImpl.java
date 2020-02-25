package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.RolePermission;
import com.cool.prc.system.mapper.RolePermissionMapper;
import com.cool.prc.system.service.RolePermissionService;
import org.springframework.stereotype.Service;

@Service("rolePermissionService")
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements RolePermissionService {

}

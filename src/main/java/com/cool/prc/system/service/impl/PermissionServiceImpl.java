package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.Permission;
import com.cool.prc.system.mapper.PermissionMapper;
import com.cool.prc.system.service.PermissionService;
import org.springframework.stereotype.Service;

@Service("permissionService")
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {

}

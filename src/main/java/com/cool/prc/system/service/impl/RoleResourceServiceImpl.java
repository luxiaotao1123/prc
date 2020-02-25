package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.RoleResource;
import com.cool.prc.system.mapper.RoleResourceMapper;
import com.cool.prc.system.service.RoleResourceService;
import org.springframework.stereotype.Service;

@Service("roleResourceService")
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements RoleResourceService {

}

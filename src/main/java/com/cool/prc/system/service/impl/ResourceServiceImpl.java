package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.Resource;
import com.cool.prc.system.mapper.ResourceMapper;
import com.cool.prc.system.service.ResourceService;
import org.springframework.stereotype.Service;

@Service("resourceService")
public class ResourceServiceImpl extends ServiceImpl<ResourceMapper, Resource> implements ResourceService {

}

package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.Host;
import com.cool.prc.system.mapper.HostMapper;
import com.cool.prc.system.service.HostService;
import org.springframework.stereotype.Service;

@Service("hostService")
public class HostServiceImpl extends ServiceImpl<HostMapper, Host> implements HostService {

}

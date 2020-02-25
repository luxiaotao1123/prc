package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.Config;
import com.cool.prc.system.mapper.ConfigMapper;
import com.cool.prc.system.service.ConfigService;
import org.springframework.stereotype.Service;

@Service("configService")
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

}

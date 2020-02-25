package com.cool.prc.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cool.prc.system.entity.Api;
import com.cool.prc.system.mapper.ApiMapper;
import com.cool.prc.system.service.ApiService;
import org.springframework.stereotype.Service;

@Service("apiService")
public class ApiServiceImpl extends ServiceImpl<ApiMapper, Api> implements ApiService {

}

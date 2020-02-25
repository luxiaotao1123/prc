package com.cool.prc.manager.service.impl;

import com.cool.prc.manager.mapper.RuleLogMapper;
import com.cool.prc.manager.entity.RuleLog;
import com.cool.prc.manager.service.RuleLogService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("ruleLogService")
public class RuleLogServiceImpl extends ServiceImpl<RuleLogMapper, RuleLog> implements RuleLogService {

}

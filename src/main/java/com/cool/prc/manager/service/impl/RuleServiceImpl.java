package com.cool.prc.manager.service.impl;

import com.cool.prc.manager.mapper.RuleMapper;
import com.cool.prc.manager.entity.Rule;
import com.cool.prc.manager.service.RuleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service("ruleService")
public class RuleServiceImpl extends ServiceImpl<RuleMapper, Rule> implements RuleService {

}

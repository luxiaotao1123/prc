package com.cool.prc.common.risk;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cool.prc.common.context.Cache;
import com.cool.prc.common.risk.model.RuleResult;
import com.cool.prc.manager.entity.Rule;
import com.cool.prc.manager.service.RuleService;
import com.core.common.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by vincent on 2020-02-25
 */
@Service
public class RiskExecute {

    @Autowired
    private RuleService ruleService;

    public boolean start(Cache cache){
        List<Rule> rules = ruleService.selectList(new EntityWrapper<Rule>().eq("status", 1).orderBy("sort"));
        for (Rule rule : rules) {
            ExecuteRule executeRule = (ExecuteRule)SpringUtils.getBean(rule.getName());
            if (Objects.isNull(executeRule)) {
                System.err.println(rule.getBean().concat("不存在"));
            } else {
                RuleResult result = executeRule.execute(cache, rule);
                if (!result.isAccept()) {
                    return false;
                }
            }
        }
        return true;
    }

}

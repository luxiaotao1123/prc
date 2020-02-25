package com.cool.prc.common.risk;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cool.prc.common.context.Cache;
import com.cool.prc.common.risk.model.RuleResult;
import com.cool.prc.manager.entity.Rule;
import com.cool.prc.manager.entity.RuleLog;
import com.cool.prc.manager.service.RuleLogService;
import com.cool.prc.manager.service.RuleService;
import com.core.common.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by vincent on 2020-02-25
 */
@Service
public class RiskExecute {

    @Autowired
    private RuleService ruleService;
    @Autowired
    private RuleLogService ruleLogService;

    public boolean start(Cache cache){
        List<Rule> rules = ruleService.selectList(new EntityWrapper<Rule>().eq("status", 1).orderBy("sort"));
        for (Rule rule : rules) {
            ExecuteRule executeRule = (ExecuteRule)SpringUtils.getBean(rule.getName());
            if (Objects.isNull(executeRule)) {
                System.err.println(rule.getBean().concat("不存在"));
            } else {

                // 开始风控
                RuleResult result = executeRule.execute(cache, rule);

                // 日志记录
                RuleLog ruleLog = new RuleLog(
                    rule.getId(),    // 所属规则[非空]
                    String.valueOf(0L),    // 客户编号[非空]
                    (short) (result.isAccept()?1:0),    // 结果[非空]
                    result.getValue(),    // 实际值
                    rule.getValue(),    // 对比值
                    null,    // 备注
                    new Date(),    // 添加时间[非空]
                    (short)1    // 状态[非空]
                );
                ruleLogService.insert(ruleLog);

                // 结果反馈
                if (!result.isAccept()) {
                    return false;
                }
            }
        }
        return true;
    }

}

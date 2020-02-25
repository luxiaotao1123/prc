package com.cool.prc.common.risk;

import com.cool.prc.common.context.Cache;
import com.cool.prc.common.risk.model.RuleResult;
import com.cool.prc.manager.entity.Rule;

public interface ExecuteRule {

	RuleResult execute(Cache cache, Rule rule);

}

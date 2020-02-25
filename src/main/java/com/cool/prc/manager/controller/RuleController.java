package com.cool.prc.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.core.common.DateUtils;
import com.cool.prc.manager.entity.Rule;
import com.cool.prc.manager.service.RuleService;
import com.core.annotations.ManagerAuth;
import com.core.common.Cools;
import com.core.common.R;
import com.core.controller.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class RuleController extends AbstractBaseController {

    @Autowired
    private RuleService ruleService;

    @RequestMapping("/rule")
    public String index(){
        return "rule/rule";
    }

    @RequestMapping("/rule_detail")
    public String detail(){
        return "rule/rule_detail";
    }

    @RequestMapping(value = "/rule/{id}/auth")
    @ResponseBody
    @ManagerAuth
    public R get(@PathVariable("id") Long id) {
        return R.ok(ruleService.selectById(String.valueOf(id)));
    }

    @RequestMapping(value = "/rule/list/auth")
    @ResponseBody
    @ManagerAuth
    public R list(@RequestParam(defaultValue = "1")Integer curr,
                  @RequestParam(defaultValue = "10")Integer limit,
                  @RequestParam Map<String, Object> param){
        excludeTrash(param);
        EntityWrapper<Rule> wrapper = new EntityWrapper<>();
        convert(param, wrapper);
        wrapper.orderBy("id", false);
        return R.ok(ruleService.selectPage(new Page<>(curr, limit), wrapper));
    }

    private void convert(Map<String, Object> map, EntityWrapper wrapper){
        for (Map.Entry<String, Object> entry : map.entrySet()){
            if (entry.getKey().endsWith(">")) {
                wrapper.ge(Cools.deleteChar(entry.getKey()), DateUtils.convert(String.valueOf(entry.getValue())));
            } else if (entry.getKey().endsWith("<")) {
                wrapper.le(Cools.deleteChar(entry.getKey()), DateUtils.convert(String.valueOf(entry.getValue())));
            } else {
                wrapper.like(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
    }

    @RequestMapping(value = "/rule/edit/auth")
    @ResponseBody
    @ManagerAuth
    public R edit(Rule rule) {
        if (Cools.isEmpty(rule)){
            return R.error();
        }
        if (null == rule.getId()){
            ruleService.insert(rule);
        } else {
            ruleService.updateById(rule);
        }
        return R.ok();
    }

    @RequestMapping(value = "/rule/add/auth")
    @ResponseBody
    @ManagerAuth
    public R add(Rule rule) {
        ruleService.insert(rule);
        return R.ok();
    }

	@RequestMapping(value = "/rule/update/auth")
    @ResponseBody
    public R update(Rule rule){
        if (Cools.isEmpty(rule) || null==rule.getId()){
            return R.error();
        }
        ruleService.updateById(rule);
        return R.ok();
    }

    @RequestMapping(value = "/rule/delete/auth")
    @ResponseBody
    @ManagerAuth
    public R delete(Integer[] ids){
        if (Cools.isEmpty(ids)){
            return R.error();
        }
        ruleService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping(value = "/rule/export/auth")
    @ResponseBody
    @ManagerAuth
    public R export(@RequestBody JSONObject param){
        List<String> fields = JSONObject.parseArray(param.getJSONArray("fields").toJSONString(), String.class);
        EntityWrapper<Rule> wrapper = new EntityWrapper<>();
        Map<String, Object> map = excludeTrash(param.getJSONObject("rule"));
        convert(map, wrapper);
        List<Rule> list = ruleService.selectList(wrapper);
        return R.ok(exportSupport(list, fields));
    }

    @RequestMapping(value = "/ruleQuery/auth")
    @ResponseBody
    @ManagerAuth
    public R query(String condition) {
        EntityWrapper<Rule> wrapper = new EntityWrapper<>();
        wrapper.like("name", condition);
        Page<Rule> page = ruleService.selectPage(new Page<>(0, 10), wrapper);
        List<Map<String, Object>> result = new ArrayList<>();
        for (Rule rule : page.getRecords()){
            Map<String, Object> map = new HashMap<>();
            map.put("id", rule.getId());
            map.put("value", rule.getName());
            result.add(map);
        }
        return R.ok(result);
    }

}

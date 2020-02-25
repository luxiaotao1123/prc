package com.cool.prc.manager.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.core.common.DateUtils;
import com.cool.prc.manager.entity.RuleLog;
import com.cool.prc.manager.service.RuleLogService;
import com.core.annotations.ManagerAuth;
import com.core.common.Cools;
import com.core.common.R;
import com.core.controller.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class RuleLogController extends AbstractBaseController {

    @Autowired
    private RuleLogService ruleLogService;

    @RequestMapping("/ruleLog")
    public String index(){
        return "ruleLog/ruleLog";
    }

    @RequestMapping("/ruleLog_detail")
    public String detail(){
        return "ruleLog/ruleLog_detail";
    }

    @RequestMapping(value = "/ruleLog/{id}/auth")
    @ResponseBody
    @ManagerAuth
    public R get(@PathVariable("id") Long id) {
        return R.ok(ruleLogService.selectById(String.valueOf(id)));
    }

    @RequestMapping(value = "/ruleLog/list/auth")
    @ResponseBody
    @ManagerAuth
    public R list(@RequestParam(defaultValue = "1")Integer curr,
                  @RequestParam(defaultValue = "10")Integer limit,
                  @RequestParam Map<String, Object> param){
        excludeTrash(param);
        EntityWrapper<RuleLog> wrapper = new EntityWrapper<>();
        convert(param, wrapper);
        wrapper.orderBy("id", false);
        return R.ok(ruleLogService.selectPage(new Page<>(curr, limit), wrapper));
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

    @RequestMapping(value = "/ruleLog/edit/auth")
    @ResponseBody
    @ManagerAuth
    public R edit(RuleLog ruleLog) {
        if (Cools.isEmpty(ruleLog)){
            return R.error();
        }
        if (null == ruleLog.getId()){
            ruleLogService.insert(ruleLog);
        } else {
            ruleLogService.updateById(ruleLog);
        }
        return R.ok();
    }

    @RequestMapping(value = "/ruleLog/add/auth")
    @ResponseBody
    @ManagerAuth
    public R add(RuleLog ruleLog) {
        ruleLogService.insert(ruleLog);
        return R.ok();
    }

	@RequestMapping(value = "/ruleLog/update/auth")
    @ResponseBody
    public R update(RuleLog ruleLog){
        if (Cools.isEmpty(ruleLog) || null==ruleLog.getId()){
            return R.error();
        }
        ruleLogService.updateById(ruleLog);
        return R.ok();
    }

    @RequestMapping(value = "/ruleLog/delete/auth")
    @ResponseBody
    @ManagerAuth
    public R delete(Integer[] ids){
        if (Cools.isEmpty(ids)){
            return R.error();
        }
        ruleLogService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    @RequestMapping(value = "/ruleLog/export/auth")
    @ResponseBody
    @ManagerAuth
    public R export(@RequestBody JSONObject param){
        List<String> fields = JSONObject.parseArray(param.getJSONArray("fields").toJSONString(), String.class);
        EntityWrapper<RuleLog> wrapper = new EntityWrapper<>();
        Map<String, Object> map = excludeTrash(param.getJSONObject("ruleLog"));
        convert(map, wrapper);
        List<RuleLog> list = ruleLogService.selectList(wrapper);
        return R.ok(exportSupport(list, fields));
    }

    @RequestMapping(value = "/ruleLogQuery/auth")
    @ResponseBody
    @ManagerAuth
    public R query(String condition) {
        EntityWrapper<RuleLog> wrapper = new EntityWrapper<>();
        wrapper.like("id", condition);
        Page<RuleLog> page = ruleLogService.selectPage(new Page<>(0, 10), wrapper);
        List<Map<String, Object>> result = new ArrayList<>();
        for (RuleLog ruleLog : page.getRecords()){
            Map<String, Object> map = new HashMap<>();
            map.put("id", ruleLog.getId());
            map.put("value", ruleLog.getId());
            result.add(map);
        }
        return R.ok(result);
    }

}

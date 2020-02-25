package com.cool.prc.manager.entity;

import com.core.common.Cools;import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.core.common.SpringUtils;
import com.cool.prc.manager.service.RuleService;
import com.baomidou.mybatisplus.annotations.TableField;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

@TableName("man_rule_log")
public class RuleLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 所属规则
     */
    @TableField("rule_id")
    private Long ruleId;

    /**
     * 客户编号
     */
    @TableField("client_id")
    private String clientId;

    /**
     * 结果 0: 禁止  1: 通过  2: 未知  
     */
    private Short accept;

    /**
     * 实际值
     */
    private String value;

    /**
     * 对比值
     */
    @TableField("verify_value")
    private String verifyValue;

    /**
     * 备注
     */
    private String memo;

    /**
     * 添加时间
     */
    @TableField("add_time")
    private Date addTime;

    /**
     * 状态 1: 正常  0: 禁用  
     */
    private Short status;

    public RuleLog() {}

    public RuleLog(Long ruleId,String clientId,Short accept,String value,String verifyValue,String memo,Date addTime,Short status) {
        this.ruleId = ruleId;
        this.clientId = clientId;
        this.accept = accept;
        this.value = value;
        this.verifyValue = verifyValue;
        this.memo = memo;
        this.addTime = addTime;
        this.status = status;
    }

//    RuleLog ruleLog = new RuleLog(
//            null,    // 所属规则[非空]
//            null,    // 客户编号[非空]
//            null,    // 结果[非空]
//            null,    // 实际值
//            null,    // 对比值
//            null,    // 备注
//            null,    // 添加时间[非空]
//            null    // 状态[非空]
//    );

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRuleId() {
        return ruleId;
    }

    public String getRuleId$(){
        RuleService service = SpringUtils.getBean(RuleService.class);
        Rule rule = service.selectById(this.ruleId);
        if (!Cools.isEmpty(rule)){
            return String.valueOf(rule.getName());
        }
        return null;
    }

    public void setRuleId(Long ruleId) {
        this.ruleId = ruleId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Short getAccept() {
        return accept;
    }

    public String getAccept$(){
        if (null == this.accept){ return null; }
        switch (this.accept){
            case 0:
                return "禁止";
            case 1:
                return "通过";
            case 2:
                return "未知";
            default:
                return String.valueOf(this.accept);
        }
    }

    public void setAccept(Short accept) {
        this.accept = accept;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVerifyValue() {
        return verifyValue;
    }

    public void setVerifyValue(String verifyValue) {
        this.verifyValue = verifyValue;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public String getAddTime$(){
        if (Cools.isEmpty(this.addTime)){
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.addTime);
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Short getStatus() {
        return status;
    }

    public String getStatus$(){
        if (null == this.status){ return null; }
        switch (this.status){
            case 1:
                return "正常";
            case 0:
                return "禁用";
            default:
                return String.valueOf(this.status);
        }
    }

    public void setStatus(Short status) {
        this.status = status;
    }


}

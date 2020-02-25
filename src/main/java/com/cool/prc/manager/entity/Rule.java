package com.cool.prc.manager.entity;

import com.core.common.Cools;import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

@TableName("man_rule")
public class Rule implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 规则名称
     */
    private String name;

    /**
     * 标识
     */
    private String flag;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 注释
     */
    private String memo;

    /**
     * 添加时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 状态 1: 正常  0: 禁用  
     */
    private Short status;

    public Rule() {}

    public Rule(String name,String flag,Integer sort,String memo,Date createTime,Date updateTime,Short status) {
        this.name = name;
        this.flag = flag;
        this.sort = sort;
        this.memo = memo;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
    }

//    Rule rule = new Rule(
//            null,    // 规则名称[非空]
//            null,    // 标识
//            null,    // 排序[非空]
//            null,    // 注释
//            null,    // 添加时间[非空]
//            null,    // 修改时间
//            null    // 状态[非空]
//    );

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getCreateTime$(){
        if (Cools.isEmpty(this.createTime)){
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public String getUpdateTime$(){
        if (Cools.isEmpty(this.updateTime)){
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.updateTime);
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

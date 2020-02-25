package com.cool.prc.manager.mapper;

import com.cool.prc.manager.entity.RuleLog;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RuleLogMapper extends BaseMapper<RuleLog> {

}

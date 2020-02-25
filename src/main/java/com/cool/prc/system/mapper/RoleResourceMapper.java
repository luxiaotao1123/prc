package com.cool.prc.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cool.prc.system.entity.RoleResource;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleResourceMapper extends BaseMapper<RoleResource> {

}

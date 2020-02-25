package com.cool.prc.system.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.cool.prc.system.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RoleMapper extends BaseMapper<Role> {

}

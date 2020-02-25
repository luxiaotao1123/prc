package com.cool.prc.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.cool.prc.system.entity.UserLogin;

public interface UserLoginService extends IService<UserLogin> {

    int selectCountByCurrentWeek();

}

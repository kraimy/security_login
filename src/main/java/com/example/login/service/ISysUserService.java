package com.example.login.service;

import com.example.login.common.BaseResponse;
import com.example.login.dto.UserDTO;
import com.example.login.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author kremi
 * @since 2022-07-09
 */
public interface ISysUserService extends IService<SysUser> {

    BaseResponse login(UserDTO userDTO);

    BaseResponse logout();
}

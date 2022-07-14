package com.example.login.service.impl;

import com.example.login.common.BaseResponse;
import com.example.login.dto.LoginSysUser;
import com.example.login.dto.UserDTO;
import com.example.login.entity.SysUser;
import com.example.login.mapper.SysUserMapper;
import com.example.login.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.login.utils.JWTUtils;
import com.example.login.utils.RedisUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author kremi
 * @since 2022-07-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    RedisUtil redisUtil;

    @Override
    public BaseResponse login(UserDTO userDTO) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword()));
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("登陆失败！");
        }
        LoginSysUser principal = (LoginSysUser) authenticate.getPrincipal();
        Map map = new HashMap();
        map.put("id", principal.getSysUser().getUserId());
        String sign = JWTUtils.sign(map);
        map.clear();
        map.put("token", sign);
        redisUtil.set("login:" + principal.getSysUser().getUserId(), principal);
        return BaseResponse.success(map);
    }

    @Override
    public BaseResponse logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginSysUser principal = (LoginSysUser) authentication.getPrincipal();
        Long userId = principal.getSysUser().getUserId();
        redisUtil.del("login:" + userId);
        return BaseResponse.success();
    }
}

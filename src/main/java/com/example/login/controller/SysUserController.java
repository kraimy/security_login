package com.example.login.controller;


import com.example.login.common.BaseResponse;
import com.example.login.dto.UserDTO;
import com.example.login.service.ISysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author kremi
 * @since 2022-07-09
 */
@RestController
@RequestMapping("/sys_user")
public class SysUserController {
    @Resource
    ISysUserService service;
    @PostMapping("login")
    public BaseResponse login(@RequestBody UserDTO userDTO){
        return service.login(userDTO);
    }
    @GetMapping("/logout")
    public BaseResponse logout(){
        return service.logout();
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('test')")
    public String kk(){
        return "dfgfd";
    }
}

package com.example.login.dto;

import com.example.login.entity.SysUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class LoginSysUser implements UserDetails {
    @ApiModelProperty("系统用户")
    private SysUser sysUser;
    @ApiModelProperty("权限")
    private List<String> AuthoritiesList;
    @JsonIgnore
    List<SimpleGrantedAuthority> authorities;

    public LoginSysUser(SysUser sysUser, List<String> list) {
        this.sysUser=sysUser;
        this.AuthoritiesList=list;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (authorities != null) return this.authorities;
        authorities = this.AuthoritiesList.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return sysUser.getPassword();
    }

    @Override
    public String getUsername() {
        return sysUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

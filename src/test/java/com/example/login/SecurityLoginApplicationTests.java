package com.example.login;

import com.auth0.jwt.interfaces.Claim;
import com.example.login.entity.Student;
import com.example.login.entity.SysUser;
import com.example.login.utils.JWTUtils;
import com.example.login.utils.RedisUtil;
import com.example.login.utils.RedisUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.Map;
import java.util.function.Function;

@SpringBootTest
class SecurityLoginApplicationTests {
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    RedisUtils redisUtils;

    @Test
    void contextLoads() throws JsonProcessingException, JSONException {
        /*Student tom = new Student();
        tom.setName(null);
        redisTemplate.opsForValue().set("tom",tom);
        Student tom1 = (Student) redisTemplate.opsForValue().get("tom");
        System.out.println(tom1);*/
        SysUser sysUser = (SysUser) redisTemplate.opsForValue().get("login:1");
        System.out.println(sysUser);

    }

}

package com.example.redisdemo.controller;

import com.example.redisdemo.dto.RedisDto;
import com.example.redisdemo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisService redisService;

    @PostMapping("/create-value")
    public RedisTemplate<Long, String> createString(Long key, String value) {
        return redisService.createString(key, value);
    }

    @PostMapping("/create-object")
    public RedisTemplate<Long, RedisDto> createObject(Long key, RedisDto dto) {
        return redisService.createObject(key, dto);
    }

    @DeleteMapping("/delete")
    public String delete(Long key) {
        return redisService.delete(key);
    }
}

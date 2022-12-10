package com.example.redisdemo.service;

import com.example.redisdemo.dto.RedisDto;
import org.springframework.data.redis.core.RedisTemplate;

public interface RedisService {
    RedisTemplate<Long, String> createString(Long key, String value);

    RedisTemplate<Long, RedisDto> createObject(Long key, RedisDto dto);

    String delete (Long key);
}

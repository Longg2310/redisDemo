package com.example.redisdemo.service.impl;

import com.example.redisdemo.dto.RedisDto;
import com.example.redisdemo.service.RedisService;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RedisServiceImpl implements RedisService {

    @Override
    public RedisTemplate<Long, String> createString(Long key, String value){
        validKey(key);
        RedisTemplate<Long, String> template = new RedisTemplate<>();
        template.opsForValue().set(key, value);
        return template;
    }

    @Override
    public RedisTemplate<Long, RedisDto> createObject(Long key, RedisDto dto){
        validKey(key);
        RedisTemplate<Long, RedisDto> template = new RedisTemplate<>();
        template.opsForValue().set(key, dto);
        return template;
    }

    @Override
    public String delete(Long key) {
        validKey(key);
        RedisTemplate<Long, Object> template = new RedisTemplate<>();
        template.delete(key);
        return "đã xoá key: " + key;
    }

    private void validKey(Long key) {
        if (key == null) {
            throw new RuntimeException("Key không được để trống");
        }
    }
}

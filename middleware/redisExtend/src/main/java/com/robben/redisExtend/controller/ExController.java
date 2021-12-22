package com.robben.redisExtend.controller;

import com.robben.redisExtend.config.JedisCompent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;


@Slf4j
@Api(tags = "redis使用")
@RestController
@RequestMapping("/redis")
public class ExController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private JedisCompent jedisCompent;
    @Autowired
    private RedisConnectionFactory connectionFactory;


    @ApiOperation(value = "test")
    @GetMapping(value = "/test")
    public int test(){
        redisTemplate.opsForValue().set("kakakakka","asdf");

        Field jedisField = ReflectionUtils.findField(JedisConnection.class, "jedis");
        ReflectionUtils.makeAccessible(jedisField);
        System.out.println(connectionFactory.getConnection());
        Jedis jedis = (Jedis) ReflectionUtils.getField(jedisField, connectionFactory.getConnection());


        jedis.set("kasdf1","123123");
        return 0;
    }




}

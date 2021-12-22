package com.robben.redisExtend.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Api(tags = "redis使用")
@RestController
@RequestMapping("/redis")
public class ExController {

    @Autowired
    private RedisTemplate redisTemplate;



    @ApiOperation(value = "test")
    @GetMapping(value = "/test")
    public int test(){
        redisTemplate.opsForValue().set("kakakakka","asdf");


        return 0;
    }




}

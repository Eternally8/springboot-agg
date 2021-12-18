package com.robben.controller;


import com.robben.service.CacheService;
import com.robben.utils.RedisUtils;
import com.robben.utils.reqResult.ResponseEntityDto;
import com.robben.utils.reqResult.UnifiedReply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "注解使用")
@RestController
@RequestMapping("/anno")
public class AnnoController extends UnifiedReply {

    @Autowired
    private CacheService userService;
    @Autowired
    private RedisUtils redisUtils;


    @ApiOperation(value = "postConstruct使用",notes = "postConstruct使用")
    @GetMapping(value = "/use")
    public ResponseEntityDto use(){


        return buildSuccesResp();
    }



}

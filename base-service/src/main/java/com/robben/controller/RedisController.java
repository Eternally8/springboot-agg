package com.robben.controller;

import com.robben.config.RedisConfig.RedisMQChannels;
import com.robben.model.UserVoEntity;
import com.robben.service.UserService;
import com.robben.utils.RedisUtils;
import com.robben.utils.reqResult.ResponseEntityDto;
import com.robben.utils.reqResult.UnifiedReply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "redis使用")
@RestController
@RequestMapping("/redis")
public class RedisController extends UnifiedReply {
    @Autowired
    private UserService userService;
    @Autowired
    private RedisUtils redisUtils;


    @ApiOperation(value = "redis注解缓存",notes = "可自定义缓存失效时间和key生成器")
    @GetMapping(value = "/getUser")
    public ResponseEntityDto<UserVoEntity> getUser(@RequestParam int id){
        userService.getUserByRedis(id);
        userService.getUserByRedisValue(id);
        userService.getUserByRedisTime(id);
        return buildSuccesResp();
    }

    @ApiOperation(value = "redis注解缓存2",notes = "可自定义缓存失效时间和key生成器")
    @GetMapping(value = "/getUser2")
    public ResponseEntityDto<UserVoEntity> getUser2(){
        UserVoEntity vo = new UserVoEntity();
        vo.setAge(1);
        vo.setId(2);
        vo.setName("kkkkk");
        return buildSuccesResp(userService.getUserByRedisTimeObject(vo));
    }

    //接受消息的方法见com.robben.redisMsg.RCMHandler
    @ApiOperation(value = "测试redis发布订阅消息")
    @GetMapping(value = "/sendRedisMsg")
    public String sendRedisMsg(@RequestParam String msg){
        redisUtils.convertAndSend(RedisMQChannels.redisChannelTest1,msg);
        redisUtils.convertAndSend(RedisMQChannels.redisChannelTest2,msg);

        return msg;
    }


}

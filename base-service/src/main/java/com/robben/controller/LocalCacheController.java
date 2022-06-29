package com.robben.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.robben.common.ResponseEntityDto;
import com.robben.common.UnifiedReply;
import com.robben.service.LocalCacheService;
import com.robben.utils.guava.GuavaCacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "本地缓存")
@RestController
@RequestMapping("/localhost")
public class LocalCacheController extends UnifiedReply {

    @Autowired
    private LocalCacheService localCacheService;


    @ApiOperation(value = "本地缓存使用")
    @GetMapping(value = "/use")
    public String use(){
        GuavaCacheUtils.setKey("aaa","bbb");

        String one = GuavaCacheUtils.getKey("aaa");
        System.out.println(one);

        ThreadUtil.sleep(3000);

        String two = GuavaCacheUtils.getKey("aaa");
        if(two == null){
            System.out.println(1);
        }
        System.out.println(two + "11");

        return "1";
    }


    @ApiOperation("本地缓存2")
    @GetMapping(value = "/localCache")
    public ResponseEntityDto<Boolean> localCache(@RequestParam String s){
        return buildSuccesResp(localCacheService.getCacheValue(s,s));
    }


}

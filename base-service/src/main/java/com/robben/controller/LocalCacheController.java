package com.robben.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.robben.utils.GuavaCacheUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "本地缓存")
@RestController
@RequestMapping("/localhost")
public class LocalCacheController {

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


}

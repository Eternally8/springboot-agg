package com.robben.service;

import com.robben.model.StudentVo;
import com.robben.service.impl.NacosProviderFeignClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * path的设置server.context-path名称相对应(获取在path上直接写ip地址也是可行的)
 * 要使用Feign的fallback机制，需要开启Feign的Hystrix的功能，新增配置如下：
 * feign:
 * hystrix:
 * enabled: true
 */
@FeignClient(value = "nacos-provider", path = "nacos-provider", fallback = NacosProviderFeignClientFallBack.class)
public interface NacosProviderFeignClient {

    @PostMapping("/nprovider/myHandle")
    StudentVo getData(@RequestBody StudentVo studentVo);

}

package com.robben.controller;

import com.robben.model.StudentVo;
import com.robben.service.NacosProviderFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "nacosProvider对外接口")
@RestController
@RequestMapping("/nconsumer")
public class ConsumerController {
    @Autowired
    private NacosProviderFeignClient nacosProviderFeignClient;

    @ApiOperation(value = "调用消费", notes = "通过feign调用nacos-provider接口")
    @GetMapping(value = "/nconsumerTest")
    public StudentVo nconsumerTest() {
        StudentVo vo = new StudentVo();
        vo.setAge(1);
        vo.setName("lalalala");
        vo.setId(1);

        StudentVo studentVo = nacosProviderFeignClient.getData(vo);
        return studentVo;
    }


}

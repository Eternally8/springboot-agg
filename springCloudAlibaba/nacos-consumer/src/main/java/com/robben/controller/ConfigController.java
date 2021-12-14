package com.robben.controller;

import org.springframework.beans.factory.annotation.Value;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "nacos配置")
@RestController
@RequestMapping("config")
//@RefreshScope
public class ConfigController {

    @Value(value = "${mynacosConfigValue}")
    private String mynacosConfigValue;

    @GetMapping(value = "/get")
    public String get() {
        return mynacosConfigValue;
    }

}
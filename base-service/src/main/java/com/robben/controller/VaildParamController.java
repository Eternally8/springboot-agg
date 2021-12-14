package com.robben.controller;

import com.robben.annotation.AuthToken;
import com.robben.constant.ParamVaildAdd;
import com.robben.model.ParamVaildReqVo;
import com.robben.utils.exception.VaildParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "权限校验",value="一个自定义的注解用于校验权限")
@RestController
@RequestMapping("/anno")
public class VaildParamController {
    /**
     * 无需校验,不加注解
     */
    @ApiOperation(value = "注解权限校验-无")
    @GetMapping("hello")
    public String hello(Integer id) {
        return "hi~ 我不需要用户权限";
    }


    /**
     * 需要角色校验，加上注解，并且写入两个角色，本文演示两个角色有一个即可访问，当然写一个可以。
     * 注：若想两个角色同时具有，修改后文的逻辑判断即可。
     * 若需要更复杂的逻辑操作，推荐使用Spring Security框架。
     */
    @ApiOperation(value = "注解权限校验-有")
    @GetMapping("needAdmin")
    @AuthToken(role_name = {"admin", "admin2"})
    public String admin(Integer id, String name, Integer age) {
        return "只有管理员角色访问成功啦!!!";
    }


    //可以增加分组来对不多接口传入同一个实体类的参数做校验
    @ApiOperation(value = "注解参数校验")
    @PostMapping("/getUser")
    public String getUserStr(@RequestBody @Validated({ParamVaildAdd.class}) ParamVaildReqVo user,
                             BindingResult bindingResult) {
        VaildParam.validData(bindingResult);
        return "success";
    }


}

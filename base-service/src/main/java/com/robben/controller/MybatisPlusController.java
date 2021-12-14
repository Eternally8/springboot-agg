package com.robben.controller;

import com.robben.model.UserMbplusInfoEntity;
import com.robben.service.MybatisPlusService;
import com.robben.utils.reqResult.ResponseEntityDto;
import com.robben.utils.reqResult.UnifiedReply;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Api(tags = "mybatis-Plus使用")
@RestController
@RequestMapping("/mybatisPlus")
public class MybatisPlusController extends UnifiedReply {
    @Autowired
    private MybatisPlusService mybatisPlusService;


    @ApiOperation(value = "插入用户信息",notes = "插入用户信息详情")
    @PostMapping("/insertUser")
    public ResponseEntityDto insertUser(@RequestBody UserMbplusInfoEntity vo){
        mybatisPlusService.insertUser(vo);

        UserMbplusInfoEntity vo2 = mybatisPlusService.getUserById(vo.getId());

        return buildSuccesResp(vo2);
    }


    @ApiOperation(value = "更新用户信息",notes = "更新用户信息")
    @PostMapping("/updateUser")
    public ResponseEntityDto updateUser(@RequestBody UserMbplusInfoEntity vo){
        UserMbplusInfoEntity result = mybatisPlusService.updateUser(vo);
        return buildSuccesResp(result);
    }

    @ApiOperation(value = "根据用户名查信息")
    @GetMapping("/getUserByName")
    public ResponseEntityDto getUserByName(@ApiParam(value = "name") String name){
        return buildSuccesResp(mybatisPlusService.getUserByName(name));
    }


}

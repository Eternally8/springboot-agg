package com.robben.controller;

import com.robben.model.DescInfoVo;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Api(tags = "mybatis-Plus使用")
@RestController
@RequestMapping("/mybatisPlus")
public class MybatisPlusController extends UnifiedReply {
    @Autowired
    private MybatisPlusService mybatisPlusService;


    @ApiOperation(value = "插入用户信息",notes = "插入用户信息详情")
    @GetMapping("/insertUser")
    public ResponseEntityDto insertUser(){
        UserMbplusInfoEntity vo = new UserMbplusInfoEntity();
        vo.setAge(1);
        vo.setCreateTime(new Date());
        vo.setSex(false);
        vo.setUpdateTime(new Date());
        vo.setWorkInfo("workinfo");

        //赋值一个json对象,这个对象中还有数组集合
        DescInfoVo dv = new DescInfoVo();
        dv.setAge(1);
        dv.setName("name");
        dv.setPhone(Arrays.asList("123","456"));
        vo.setDescInfo(dv);

        //赋值一个json集合
        List<DescInfoVo> ld = new ArrayList<>();
        ld.add(dv);
        vo.setDescInfoArrary(ld);

        mybatisPlusService.insertUser(vo);
        return buildSuccesResp(vo);
    }


    @ApiOperation(value = "更新用户信息",notes = "更新用户信息,增加了时间字段的转换、JSON格式数据的使用")
    @PostMapping("/updateUser")
    public ResponseEntityDto updateUser(@RequestBody UserMbplusInfoEntity vo){
        UserMbplusInfoEntity result = mybatisPlusService.updateUser(vo);
        return buildSuccesResp(result);
    }


    @ApiOperation(value = "根据用户名查信息")
    @GetMapping("/getUserByName")
    public ResponseEntityDto getUserByName(@ApiParam String name){
        return buildSuccesResp(mybatisPlusService.getUserByName(name));
    }


}

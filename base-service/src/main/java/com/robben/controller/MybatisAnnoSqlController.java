package com.robben.controller;

import com.robben.model.UserVoEntity;
import com.robben.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Api(tags = "mybatis注解sql使用")
@RestController
@RequestMapping("/mybatis")
public class MybatisAnnoSqlController {
    @Autowired
    private UserService userService;


    @ApiOperation(value = "插入用户信息",notes = "插入用户信息详情")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name",value="用户名称",required = true),
            @ApiImplicitParam(name = "age",value="用户年龄",required = true),
            @ApiImplicitParam(name = "sex",value="性别",dataTypeClass = Boolean.class, required = true)
    })
    @GetMapping("/insertUser")
    public UserVoEntity insertUser(String name, int age, boolean sex){
        log.info("getUser_name:{}",name);

        UserVoEntity vo = new UserVoEntity();
        vo.setName(name);
        vo.setAge(age);
        vo.setSex(sex);
        userService.insertUser(vo);
        return vo;
    }


    @ApiOperation(value = "获取单个用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="id",required = true)
    })
    @GetMapping("/getUserById")
    public UserVoEntity getUserById(int id){
        return userService.getUserById(id);
    }

    @ApiOperation(value = "更新用户信息",notes = "会返回影响的行数")
    @PostMapping("/updateUser")
    public int updateUser(@RequestBody UserVoEntity vo){
        return userService.updateUser(vo);
    }


    @ApiOperation(value = "删除用户信息",notes = "会返回影响的行数")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value="id",required = true)
    })
    @DeleteMapping("/delUserById")
    public int delUserById(int id){
        return userService.delUserById(id);
    }



    @ApiOperation(value = "测试filter使用")
    @PostMapping(value = "/getUser2")
    public UserVoEntity getUser2(@RequestBody UserVoEntity reqVo){
        log.info("getUser2_reqVo:{}",reqVo);

        return reqVo;
    }

    @ApiOperation(value = "测试interceptor使用")
    @PostMapping(value = "/getUser3")
    public UserVoEntity getUser3(String name){
        log.info("getUser3_name:{}",name);

        return null;
    }


    @ApiOperation(value = "错误页面",notes = "错误详细信息")
    @PostMapping(value = "/failed")
    public Map<String,String> failed(){
        log.info("~~~failed~~~");

        Map<String,String> map = new HashMap<>();
        map.put("code","500");
        map.put("msg","fail");
        return map;
    }

}

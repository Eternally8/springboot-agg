package com.robben.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.robben.common.ResponseEntityDto;
import com.robben.common.UnifiedReply;
import com.robben.dao.UserInfoMapper;
import com.robben.entity.UserInfoEntity;
import com.robben.entity.DescInfoListVo;
import com.robben.entity.DescInfoVo;
import com.robben.utils.DesUtil;
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
    private UserInfoMapper userInfoMapper;
    private static String sqlCryptoKey = "asdfasdf2qwer123@#asdf";


    @ApiOperation(value = "插入用户信息",notes = "插入用户信息详情")
    @GetMapping("/insertUser")
    public ResponseEntityDto insertUser(){
        UserInfoEntity vo = new UserInfoEntity();
        vo.setAge(1);
        vo.setName("lalalalal");
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

        //赋值一个json集合对象
        List<DescInfoVo> ld = new ArrayList<>();
        ld.add(dv);
        vo.setDescInfoList(ld);

        //赋值一个对象,对象中有list
        DescInfoListVo descInfoListVo = new DescInfoListVo();
        descInfoListVo.setDlist(ld);
        vo.setDescInfoListVo(descInfoListVo);

        userInfoMapper.insert(vo);
        return buildSuccesResp(vo);
    }


    @ApiOperation(value = "更新用户信息",notes = "更新用户信息,增加了时间字段的转换、JSON格式数据的使用")
    @PostMapping("/updateUser")
    public ResponseEntityDto updateUser(@RequestBody UserInfoEntity vo){
        int result = userInfoMapper.updateById(vo);

        userInfoMapper.update(vo,new LambdaQueryWrapper<UserInfoEntity>().eq(UserInfoEntity::getId,1));

        return buildSuccesResp(result);
    }

    @ApiOperation(value = "根据用户ID")
    @GetMapping("/getUserById")
    public ResponseEntityDto getUserById(@ApiParam int id){
        return buildSuccesResp(userInfoMapper.selectById(id));
    }


    @ApiOperation(value = "根据用户名查信息")
    @GetMapping("/getUserByName")
    public ResponseEntityDto getUserByName(@ApiParam String name){
        return buildSuccesResp(userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfoEntity>()
                .eq(UserInfoEntity::getName,name).apply(" limt 1")));
    }


    @ApiOperation(value = "执行任何sql")
    @PostMapping("/handleSql")
    public ResponseEntityDto handleSql(@RequestParam String sqlStr){
        userInfoMapper.handleSql(sqlStr);
        return buildSuccesResp();
    }


    public static void main(String[] args) throws Exception {
        String sqlStr = "select * from user_info";
        DesUtil des = new DesUtil("sqlCryptoKey");
        System.out.println(des.encrypt(sqlStr));
        System.out.println(des.decrypt(des.encrypt(sqlStr)));

    }


}

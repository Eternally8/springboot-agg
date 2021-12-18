package com.robben.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.robben.dao.mybatisPlus.UserMbplusInfoMapper;
import com.robben.model.UserMbplusInfoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class MybatisPlusService {

    @Autowired
    private UserMbplusInfoMapper userMbplusInfoMapper;


    public void insertUser(UserMbplusInfoEntity vo) {
        userMbplusInfoMapper.insert(vo);
    }

    public UserMbplusInfoEntity getUserById(Integer id) {
        return userMbplusInfoMapper.selectById(id);
    }


    public UserMbplusInfoEntity updateUser(UserMbplusInfoEntity vo) {
        int updateCount = userMbplusInfoMapper.updateById(vo);
        log.info("mybaits-plus更新的数量:{}",updateCount);

        return userMbplusInfoMapper.selectById(vo.getId());
    }


    public List<UserMbplusInfoEntity> getUserByName(String name) {
        QueryWrapper<UserMbplusInfoEntity> q = new QueryWrapper<>();
        q.like("name", name);
        return userMbplusInfoMapper.selectList(q);
    }
}

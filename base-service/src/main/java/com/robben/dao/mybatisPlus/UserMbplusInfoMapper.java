package com.robben.dao.mybatisPlus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.robben.model.UserMbplusInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMbplusInfoMapper extends BaseMapper<UserMbplusInfoEntity> {

}
